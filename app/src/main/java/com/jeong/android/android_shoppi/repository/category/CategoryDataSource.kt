package com.jeong.android.android_shoppi.repository.category

import com.jeong.android.android_shoppi.model.Category

interface CategoryDataSource {

    suspend fun getCategories() : List<Category>
}