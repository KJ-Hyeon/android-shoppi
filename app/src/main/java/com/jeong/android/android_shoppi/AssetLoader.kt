package com.jeong.android.android_shoppi

import android.content.Context
import android.util.Log

class AssetLoader {

    fun getJsonString(context: Context, fileName: String): String? {
        return kotlin.runCatching {
            loadAsset(context, fileName)
        }.getOrNull()
        // getOrNull함수 사용시 runCatching 내부에서 Exception이 발생할때 반환값을 Null로 받을수 있다
    }

    private fun loadAsset(context: Context, fileName: String): String {
        // assets폴더 접근
        return context.assets.open(fileName).use { inputStream ->
            val size = inputStream.available()
            val bytes = ByteArray(size)
            inputStream.read(bytes)
            String(bytes)
        }
    }
}