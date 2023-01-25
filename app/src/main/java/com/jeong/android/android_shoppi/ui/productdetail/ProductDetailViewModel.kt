package com.jeong.android.android_shoppi.ui.productdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeong.android.android_shoppi.model.Product
import com.jeong.android.android_shoppi.repository.cart.CartRepository
import com.jeong.android.android_shoppi.repository.productdetail.ProductDetailRepository
import com.jeong.android.android_shoppi.ui.common.Event
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val productDetailRepository: ProductDetailRepository,
    private val cartRepository: CartRepository
) : ViewModel() {

    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> = _product

    // Unit인 이유는 button을 클릭할때 UI에 전달할 데이터가 없기 때문에
    private val _addCartEvent = MutableLiveData<Event<Unit>>()
    val addCartEvent : LiveData<Event<Unit>> = _addCartEvent

    fun loadProductDetail(productId: String) {
        viewModelScope.launch {
            _product.value = productDetailRepository.getProductDetail(productId)
        }
    }

    fun addCart(product : Product) {
        viewModelScope.launch {
            cartRepository.addCartItem(product)
            _addCartEvent.value = Event(Unit)
        }
    }
}