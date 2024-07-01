package com.bhavanshu.dalwadi.practicaltest.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bhavanshu.dalwadi.practicaltest.repositories.CategoryRepository

class CategoryViewModelFactory(val app: Application, private val categoryRepository: CategoryRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CategoryViewModel(app, categoryRepository) as T
    }
}