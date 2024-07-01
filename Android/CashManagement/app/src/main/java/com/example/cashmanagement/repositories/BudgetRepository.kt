package com.example.cashmanagement.repositories

import com.example.cashmanagement.database.CashMangemantDatabase
import com.example.cashmanagement.models.BudgetModel

class BudgetRepository(private val db: CashMangemantDatabase) {
    suspend fun insertBudget(budget: BudgetModel) = db.getBudgetDao().insertBudget(budget)
    suspend fun updateBudget(budget: BudgetModel) = db.getBudgetDao().updateBudget(budget)
    suspend fun deleteBudget(budget: BudgetModel) = db.getBudgetDao().deleteBudget(budget)

    fun getAllBudget() = db.getBudgetDao().getAllBudget()
    fun getBudgetById(id: Int) = db.getBudgetDao().getBudgetById(id)
}