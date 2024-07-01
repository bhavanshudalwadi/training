package com.bhavanshu.dalwadi.practicaltest.viewmodels

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.bhavanshu.dalwadi.practicaltest.models.CategoryModel
import com.bhavanshu.dalwadi.practicaltest.repositories.CategoryRepository
import kotlinx.coroutines.launch

class CategoryViewModel(app: Application, private val categoryRepository: CategoryRepository): AndroidViewModel(app) {

    fun addCategory(category: CategoryModel) = viewModelScope.launch {
        categoryRepository.insertCategory(category)
    }

    fun updateCategory(category: CategoryModel) = viewModelScope.launch {
        categoryRepository.updateCategory(category)
    }

    fun deleteCategory(category: CategoryModel) = viewModelScope.launch {
        categoryRepository.deleteCategory(category)
    }

    fun getCategory(id: Int) = categoryRepository.getCategoryById(id)

    fun getAllCategory() = categoryRepository.getAllCategories()
}