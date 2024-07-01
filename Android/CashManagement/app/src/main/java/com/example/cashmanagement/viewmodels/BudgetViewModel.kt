package com.example.cashmanagement.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.cashmanagement.models.BudgetModel
import com.example.cashmanagement.models.CategoryModel
import com.example.cashmanagement.repositories.BudgetRepository
import com.example.cashmanagement.repositories.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BudgetViewModel(app: Application, private val budgetRepository: BudgetRepository): AndroidViewModel(app) {

    fun addBudget(budget: BudgetModel) = viewModelScope.launch {
        budgetRepository.insertBudget(budget)
    }

    fun updateBudget(budget: BudgetModel) = viewModelScope.launch {
        budgetRepository.updateBudget(budget)
    }

    fun deleteBudget(budget: BudgetModel) = viewModelScope.launch {
        budgetRepository.deleteBudget(budget)
    }

    fun getAllBudget() = budgetRepository.getAllBudget()
}