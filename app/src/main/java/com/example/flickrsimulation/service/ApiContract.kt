package com.example.flickrsimulation.service

import androidx.lifecycle.LiveData
import com.example.flickrsimulation.model.FailureResponse
import com.example.flickrsimulation.model.FlickrResponse
import com.example.flickrsimulation.model.Response

interface ApiContract {

    fun searchFlickrPhotos(
        query: String,
        page: Int
    ): LiveData<Response<FlickrResponse, FailureResponse>>
}