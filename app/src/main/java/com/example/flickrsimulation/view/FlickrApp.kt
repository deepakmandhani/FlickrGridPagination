package com.example.flickrsimulation.view

import android.app.Application

class FlickrApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: FlickrApp
            private set
    }
}