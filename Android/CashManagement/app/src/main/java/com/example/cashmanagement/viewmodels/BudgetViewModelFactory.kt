package com.example.cashmanagement.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cashmanagement.repositories.BudgetRepository
import com.example.cashmanagement.repositories.CategoryRepository

class BudgetViewModelFactory(val app: Application, private val budgetRepository: BudgetRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BudgetViewModel(app, budgetRepository) as T
    }
}