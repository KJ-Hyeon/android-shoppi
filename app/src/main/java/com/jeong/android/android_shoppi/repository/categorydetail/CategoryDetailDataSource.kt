package com.jeong.android.android_shoppi.repository.categorydetail

import com.jeong.android.android_shoppi.model.CategoryDetail

interface CategoryDetailDataSource {

    suspend fun getCategoryDetail() : CategoryDetail
}