package com.example.cashmanagement.database

import androidx.annotation.RequiresPermission
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.cashmanagement.models.CategoryModel

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertCategory(category: CategoryModel)

    @Update
    suspend fun updateCategory(category: CategoryModel)

    @Delete
    suspend fun deleteCategory(category: CategoryModel)

    @Query("SELECT * FROM categories ORDER BY id DESC")
    fun getAllCategory(): LiveData<List<CategoryModel>>

    @Query("SELECT * FROM categories WHERE id=:id LIMIT 1")
    fun getCategoryById(id: Int): CategoryModel
}