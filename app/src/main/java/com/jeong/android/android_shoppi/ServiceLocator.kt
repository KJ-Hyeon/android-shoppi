package com.jeong.android.android_shoppi

import com.jeong.android.android_shoppi.network.ApiClient

object ServiceLocator {

    private var apiClient : ApiClient? = null

    fun provideApiClient() : ApiClient {
        return apiClient ?: kotlin.run {
            ApiClient.create().also {
                apiClient = it
            }
        }
    }
}