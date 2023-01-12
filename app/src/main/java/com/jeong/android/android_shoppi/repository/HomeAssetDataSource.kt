package com.jeong.android.android_shoppi.repository

import com.google.gson.Gson
import com.jeong.android.android_shoppi.AssetLoader
import com.jeong.android.android_shoppi.model.HomeData

class HomeAssetDataSource(private val assetLoader: AssetLoader) : HomeDataSource {

    private val gson = Gson()

    override fun getHomeData(): HomeData? {
        return assetLoader.getJsonString("home.json").let { homeJsonString ->
            gson.fromJson(homeJsonString, HomeData::class.java)
        }
    }
}