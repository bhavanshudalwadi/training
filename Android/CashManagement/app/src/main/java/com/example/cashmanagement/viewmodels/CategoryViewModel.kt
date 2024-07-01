package com.example.cashmanagement.viewmodels

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.cashmanagement.MainActivity
import com.example.cashmanagement.fragments.CategoriesFragment
import com.example.cashmanagement.fragments.EditCategoryFragment
import com.example.cashmanagement.models.CategoryModel
import com.example.cashmanagement.repositories.CategoryRepository
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