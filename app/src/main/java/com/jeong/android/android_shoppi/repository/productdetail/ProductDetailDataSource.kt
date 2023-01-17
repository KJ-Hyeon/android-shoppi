package com.jeong.android.android_shoppi.repository.productdetail

import com.jeong.android.android_shoppi.model.Product
import retrofit2.http.GET

interface ProductDetailDataSource {

    suspend fun getProductDetail(productId : String) : Product
}