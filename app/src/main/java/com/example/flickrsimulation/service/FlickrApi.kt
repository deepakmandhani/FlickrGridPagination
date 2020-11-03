package com.example.flickrsimulation.service

import com.example.flickrsimulation.model.FlickrResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {

    @GET("rest")
    fun searchFlickrPhotos(
        @Query("text") text: String = "",
        @Query("page") page: Int = 1,
        @Query("method") method: String = "flickr.photos.search",
        @Query("api_key") apiKey: String = "3e7cc266ae2b0e0d78e279ce8e361736",
        @Query("format") format: String = "json",
        @Query("nojsoncallback") nojsoncallback: Int = 1
    ): Call<FlickrResponse>
}