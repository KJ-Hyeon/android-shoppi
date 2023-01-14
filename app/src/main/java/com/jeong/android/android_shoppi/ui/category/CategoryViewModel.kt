package com.jeong.android.android_shoppi.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeong.android.android_shoppi.model.Category
import com.jeong.android.android_shoppi.repository.CategoryRepository
import com.jeong.android.android_shoppi.ui.common.Event
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {

    private val _items = MutableLiveData<List<Category>>()
    val items : LiveData<List<Category>> = _items

    private val _openCategoryEvent = MutableLiveData<Event<Category>>()
    val openCategoryEvent : LiveData<Event<Category>> = _openCategoryEvent

    init {
        loadCategory()
    }

    fun openCategoryDetail(category: Category) {
        _openCategoryEvent.value = Event(category)
    }

    private fun loadCategory() {
        viewModelScope.launch {
            val categories = categoryRepository.getCategories()
            _items.value = categories
        }
    }
}