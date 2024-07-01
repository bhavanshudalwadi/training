package com.example.cashmanagement.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.cashmanagement.models.BudgetModel

@Dao
interface BudgetDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertBudget(category: BudgetModel)

    @Update
    suspend fun updateBudget(category: BudgetModel)

    @Delete
    suspend fun deleteBudget(category: BudgetModel)

    @Query("SELECT * FROM budgets ORDER BY id DESC")
    fun getAllBudget(): LiveData<List<BudgetModel>>

    @Query("SELECT * FROM budgets WHERE id = :id")
    fun getBudgetById(id: Int): LiveData<List<BudgetModel>>
}