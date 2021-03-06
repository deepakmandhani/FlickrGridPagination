package com.example.flickrsimulation.view

import androidx.lifecycle.*
import com.example.flickrsimulation.common.AppRepository
import com.example.flickrsimulation.model.FailureResponse
import com.example.flickrsimulation.model.Photos

class AppViewModel(private val repo: AppRepository) : ViewModel() {

    private val mediatorLiveData = MediatorLiveData<Photos>()
    private val failureResponse = MutableLiveData<FailureResponse>()

    fun observeLiveData(): LiveData<Photos> {
        return mediatorLiveData
    }

    fun observeFailure(): LiveData<FailureResponse> {
        return failureResponse
    }

    fun searchFlickrPhotos(query: String, page: Int) {
        val liveData = repo.searchFlickrPhotos(query, page)
        mediatorLiveData.addSource(liveData) {
            it.obj?.photos?.let {
                if (it.photo.isNullOrEmpty())
                    failureResponse.postValue(FailureResponse(1))
                else
                    mediatorLiveData.postValue(it)
            } ?: run {
                failureResponse.postValue(it.failure)
            }
            mediatorLiveData.removeSource(liveData)
        }
    }

    class AppViewModelFactory(private val repo: AppRepository) :
        ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return AppViewModel(repo) as T
        }
    }
}