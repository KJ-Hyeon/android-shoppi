package com.jeong.android.android_shoppi.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jeong.android.android_shoppi.AssetLoader
import com.jeong.android.android_shoppi.network.ApiClient
import com.jeong.android.android_shoppi.repository.CategoryRemoteDataSource
import com.jeong.android.android_shoppi.repository.CategoryRepository
import com.jeong.android.android_shoppi.repository.HomeAssetDataSource
import com.jeong.android.android_shoppi.repository.HomeRepository
import com.jeong.android.android_shoppi.ui.category.CategoryViewModel
import com.jeong.android.android_shoppi.ui.home.HomeViewModel

// 생성자를 가진 ViewModel을 생성하기 위한 클래스
class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                val homeRepository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
                HomeViewModel(homeRepository) as T
            }
            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                val repository = CategoryRepository(CategoryRemoteDataSource(ApiClient.create()))
                CategoryViewModel(repository) as T
            }
            else -> {
                throw IllegalAccessException("Failed to create ViewModel ${modelClass.name}")
            }
        }
    }
}