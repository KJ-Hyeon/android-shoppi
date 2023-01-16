package com.jeong.android.android_shoppi.repository.categorydetail

import com.jeong.android.android_shoppi.model.CategoryDetail

class CategoryDetailRepository(private val remoteDataSource: CategoryDetailRemoteDataSource) {

    suspend fun getCategoryDetail(): CategoryDetail {
        return remoteDataSource.getCategoryDetail()
    }
}