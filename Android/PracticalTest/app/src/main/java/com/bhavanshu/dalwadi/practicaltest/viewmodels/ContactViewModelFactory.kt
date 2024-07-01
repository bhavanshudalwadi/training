package com.bhavanshu.dalwadi.practicaltest.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bhavanshu.dalwadi.practicaltest.repositories.ContactRepository

class ContactViewModelFactory(val app: Application, private val contactRepository: ContactRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ContactViewModel(app, contactRepository) as T
    }
}