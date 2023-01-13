package com.jeong.android.android_shoppi.network

import com.google.gson.Gson
import com.jeong.android.android_shoppi.model.Category
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiClient {

    @GET("categories.json")
    suspend fun getCategories() : List<Category>


    companion object {

        private const val baseUrl = "https://shoppi-android-32da9-default-rtdb.asia-southeast1.firebasedatabase.app/"

        fun create() :ApiClient {

            // network 통신의 결과를 Log 메시지로 출력
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiClient::class.java)
        }
    }
}