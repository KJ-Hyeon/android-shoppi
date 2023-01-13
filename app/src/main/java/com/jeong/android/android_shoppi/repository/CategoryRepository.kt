package com.jeong.android.android_shoppi.repository

import com.jeong.android.android_shoppi.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryRepository(private val categoryRemoteDataSource: CategoryRemoteDataSource) {

    // suspend 키워드를 사용했기 때문에, getCategories함수는 코루틴 내부가 아니면 사용을 할 수 가 없는상태
    suspend fun getCategories() : List<Category> {
        return categoryRemoteDataSource.getCategories()
    }
}