package com.jeong.android.android_shoppi.repository

import com.jeong.android.android_shoppi.model.HomeData

class HomeRepository(private val assetDataSource : HomeAssetDataSource)  {

    fun getHomeData() : HomeData? {
        return assetDataSource.getHomeData()
    }
}