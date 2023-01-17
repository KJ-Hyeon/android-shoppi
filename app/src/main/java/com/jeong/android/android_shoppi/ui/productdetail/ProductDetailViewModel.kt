package com.jeong.android.android_shoppi.ui.productdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeong.android.android_shoppi.model.Product
import com.jeong.android.android_shoppi.repository.productdetail.ProductDetailRepository
import kotlinx.coroutines.launch

class ProductDetailViewModel(private val repository: ProductDetailRepository) : ViewModel() {

    private val _product =MutableLiveData<Product>()
    val product : LiveData<Product> = _product

    fun loadProductDetail(productId : String) {
        viewModelScope.launch {
            _product.value = repository.getProductDetail(productId)
        }
    }
}