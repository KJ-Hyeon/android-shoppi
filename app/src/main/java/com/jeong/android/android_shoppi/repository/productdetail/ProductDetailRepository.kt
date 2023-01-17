package com.jeong.android.android_shoppi.repository.productdetail

import com.jeong.android.android_shoppi.model.Product

class ProductDetailRepository(private val remoteDataSource: ProductDetailRemoteDataSource) {

    suspend fun getProductDetail(productId: String): Product {
        return remoteDataSource.getProductDetail(productId)
    }
}