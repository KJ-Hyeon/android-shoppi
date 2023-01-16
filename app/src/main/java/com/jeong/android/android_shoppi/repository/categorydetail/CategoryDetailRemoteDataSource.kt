package com.jeong.android.android_shoppi.repository.categorydetail

import com.jeong.android.android_shoppi.model.Category
import com.jeong.android.android_shoppi.model.CategoryDetail
import com.jeong.android.android_shoppi.network.ApiClient
import com.jeong.android.android_shoppi.repository.category.CategoryDataSource

class CategoryDetailRemoteDataSource(private val apiClient: ApiClient) : CategoryDetailDataSource {

    override suspend fun getCategoryDetail(): CategoryDetail {
        return apiClient.getCategoryDetail()
    }
}