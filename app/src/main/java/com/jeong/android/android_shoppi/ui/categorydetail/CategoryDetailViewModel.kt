package com.jeong.android.android_shoppi.ui.categorydetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeong.android.android_shoppi.model.Promotion
import com.jeong.android.android_shoppi.model.TopSelling
import com.jeong.android.android_shoppi.repository.categorydetail.CategoryDetailRepository
import kotlinx.coroutines.launch

class CategoryDetailViewModel(private val repository: CategoryDetailRepository) : ViewModel() {

    private val _topSelling = MutableLiveData<TopSelling>()
    val topSelling : LiveData<TopSelling> = _topSelling

    private val _promotion = MutableLiveData<Promotion>()
    val promotion : LiveData<Promotion> = _promotion

    init {
        loadCategoryDetail()
    }

    private fun loadCategoryDetail() {
        viewModelScope.launch {
            val categoryDetail = repository.getCategoryDetail()
            _topSelling.value = categoryDetail.topSelling
            _promotion.value = categoryDetail.promotion
        }
    }
}