package com.jeong.android.android_shoppi.repository.cart

import com.jeong.android.android_shoppi.database.CartItemDao
import com.jeong.android.android_shoppi.model.CartItem

class CartItemLocalDataSource(private val dao: CartItemDao): CartItemDataSource {

    override suspend fun getCartItems(): List<CartItem> {
        return dao.load()
    }

    override suspend fun addCartItem(cartItem: CartItem) {
        dao.insert(cartItem)
    }
}