package com.jeong.android.android_shoppi.repository.productdetail

import com.jeong.android.android_shoppi.model.Product
import com.jeong.android.android_shoppi.network.ApiClient

class ProductDetailRemoteDataSource (private val apiClient: ApiClient) : ProductDetailDataSource  {

    override suspend fun getProductDetail(productId: String): Product {
        return apiClient.getProductDetail(productId)
    }
}