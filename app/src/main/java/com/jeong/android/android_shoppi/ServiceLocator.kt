package com.jeong.android.android_shoppi

import android.content.Context
import androidx.room.Room
import com.jeong.android.android_shoppi.database.AppDatabase
import com.jeong.android.android_shoppi.network.ApiClient
import com.jeong.android.android_shoppi.repository.cart.CartItemLocalDataSource
import com.jeong.android.android_shoppi.repository.cart.CartRepository

object ServiceLocator {

    private var apiClient: ApiClient? = null
    private var database: AppDatabase? = null
    private var cartRepository: CartRepository? = null

    fun provideApiClient(): ApiClient {
        // null인 경우 run구문을 실행 null이 아닌경우 기존의 apiClient를 반환
        return apiClient ?: kotlin.run {
            ApiClient.create().also {
                apiClient = it
            }
        }
    }

    private fun provideDatabase(applicationContext: Context): AppDatabase {
        return database ?: kotlin.run {
            Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "shoppi-local"
            ).build().also {
                database = it
            }
        }
    }

    fun provideCartRepository(context: Context): CartRepository {
        return cartRepository ?: kotlin.run {
            val dao = provideDatabase(context.applicationContext).cartItemDao()
            CartRepository(CartItemLocalDataSource(dao)).also {
                cartRepository = it
            }
        }
    }
}