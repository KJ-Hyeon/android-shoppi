package com.jeong.android.android_shoppi.repository.home

import com.jeong.android.android_shoppi.model.HomeData

interface HomeDataSource {

    fun getHomeData() : HomeData?
}