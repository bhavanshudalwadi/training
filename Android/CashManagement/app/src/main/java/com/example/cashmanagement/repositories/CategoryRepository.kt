package com.example.cashmanagement.repositories

import com.example.cashmanagement.database.CashMangemantDatabase
import com.example.cashmanagement.models.CategoryModel

class CategoryRepository(private val db: CashMangemantDatabase) {
    suspend fun insertCategory(category: CategoryModel) = db.getCategoryDao().insertCategory(category)
    suspend fun updateCategory(category: CategoryModel) = db.getCategoryDao().updateCategory(category)
    suspend fun deleteCategory(category: CategoryModel) = db.getCategoryDao().deleteCategory(category)

    fun getAllCategories() = db.getCategoryDao().getAllCategory()
    fun getCategoryById(id: Int) = db.getCategoryDao().getCategoryById(id)
}