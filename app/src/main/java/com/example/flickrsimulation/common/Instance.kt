package com.example.flickrsimulation.common

import com.example.flickrsimulation.service.ApiService

object Instance {

    private var appRepository: AppRepository? = null

    fun getAppRepository(): AppRepository {
        appRepository?.let {
            return it
        }
        return AppRepository(ApiService()).also {
            appRepository = it
        }
    }
}