package com.jeong.android.android_shoppi.ui.cart

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeong.android.android_shoppi.model.CartItem
import com.jeong.android.android_shoppi.repository.cart.CartRepository
import com.jeong.android.android_shoppi.ui.common.Event
import kotlinx.coroutines.launch

class CartViewModel(private val cartRepository: CartRepository): ViewModel() {


    // items을 observe할때, 2번 발생되는 문제를 해결하기 위해 Event를 사용
    private val _items = MutableLiveData<Event<List<CartItem>>>()
    val items: LiveData<Event<List<CartItem>>> = _items

    fun loadCartItem() {
        viewModelScope.launch {
            _items.value = Event(cartRepository.getCartItems())
            Log.e("ViewModeLoadCartItem", "${items.value}")
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("CartViewModelOnCleared","CartViewModelOnCleared")
    }
}

// TODO navigation Version이 2.5.3인 경우에 어떻게 해야할지 생각 해보고 2.5.3버전으로 맞게 대응 한 뒤 git commit