package com.jeong.android.android_shoppi.repository.cart

import com.jeong.android.android_shoppi.model.CartItem

interface CartItemDataSource {

    suspend fun addCartItem(cartItem: CartItem)

    suspend fun getCartItems(): List<CartItem>

}