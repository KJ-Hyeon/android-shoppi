package com.jeong.android.android_shoppi.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jeong.android.android_shoppi.model.Banner
import com.jeong.android.android_shoppi.model.Title
import com.jeong.android.android_shoppi.repository.HomeRepository

// AAC의 ViewModel을 사용
class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val _title = MutableLiveData<Title>()
    val title : LiveData<Title> = _title

    private val _topBanners = MutableLiveData<List<Banner>>()
    val topBanners : LiveData<List<Banner>> = _topBanners

    init {
        loadHomeData()
    }

    private fun loadHomeData() {
        val homeData = homeRepository.getHomeData()
        homeData?.let { homeData ->
            _title.value = homeData.title
            _topBanners.value = homeData.topBanners
        }
    }
}