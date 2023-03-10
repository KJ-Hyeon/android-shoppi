package com.jeong.android.android_shoppi.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jeong.android.android_shoppi.model.Banner
import com.jeong.android.android_shoppi.model.Product
import com.jeong.android.android_shoppi.model.Promotion
import com.jeong.android.android_shoppi.model.Title
import com.jeong.android.android_shoppi.repository.home.HomeRepository
import com.jeong.android.android_shoppi.ui.common.Event

// AAC의 ViewModel을 사용
class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val _title = MutableLiveData<Title>()
    val title : LiveData<Title> = _title

    private val _topBanners = MutableLiveData<List<Banner>>()
    val topBanners : LiveData<List<Banner>> = _topBanners

    private val _promotions = MutableLiveData<Promotion>()
    val promotions : LiveData<Promotion> = _promotions

    private val _openProductDetail = MutableLiveData<Event<String>>()
    val openProductDetail : LiveData<Event<String>> = _openProductDetail

    init {
        loadHomeData()
    }

    private fun loadHomeData() {
        val homeData = homeRepository.getHomeData()
        homeData?.let { homeData ->
            _title.value = homeData.title
            _topBanners.value = homeData.topBanners
            _promotions.value = homeData.promotions
        }
    }

    fun openProductDetail(productId: String) {
        _openProductDetail.value = Event(productId)
    }
}