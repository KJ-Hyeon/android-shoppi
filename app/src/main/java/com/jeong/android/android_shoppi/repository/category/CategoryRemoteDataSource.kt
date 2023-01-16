package com.jeong.android.android_shoppi.repository.category

import com.jeong.android.android_shoppi.model.Category
import com.jeong.android.android_shoppi.network.ApiClient

class CategoryRemoteDataSource(private val apiClient: ApiClient) : CategoryDataSource {

    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}