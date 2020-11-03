package com.example.flickrsimulation.common

import androidx.lifecycle.LiveData
import com.example.flickrsimulation.model.FailureResponse
import com.example.flickrsimulation.model.FlickrResponse
import com.example.flickrsimulation.model.Response
import com.example.flickrsimulation.service.ApiContract

class AppRepository(private val apiContract: ApiContract) {

    fun searchFlickrPhotos(
        query: String,
        page: Int
    ): LiveData<Response<FlickrResponse, FailureResponse>> {
        return apiContract.searchFlickrPhotos(query, page)
    }
}