package com.jeong.android.android_shoppi.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jeong.android.android_shoppi.AssetLoader
import com.jeong.android.android_shoppi.network.ApiClient
import com.jeong.android.android_shoppi.repository.category.CategoryRemoteDataSource
import com.jeong.android.android_shoppi.repository.category.CategoryRepository
import com.jeong.android.android_shoppi.repository.categorydetail.CategoryDetailRemoteDataSource
import com.jeong.android.android_shoppi.repository.categorydetail.CategoryDetailRepository
import com.jeong.android.android_shoppi.repository.home.HomeAssetDataSource
import com.jeong.android.android_shoppi.repository.home.HomeRepository
import com.jeong.android.android_shoppi.ui.category.CategoryViewModel
import com.jeong.android.android_shoppi.ui.categorydetail.CategoryDetailViewModel
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
            modelClass.isAssignableFrom(CategoryDetailViewModel::class.java) -> {
                val repository = CategoryDetailRepository(CategoryDetailRemoteDataSource(ApiClient.create()))
                CategoryDetailViewModel(repository) as T
            }
            else -> {
                throw IllegalAccessException("Failed to create ViewModel ${modelClass.name}")
            }
        }
    }
}