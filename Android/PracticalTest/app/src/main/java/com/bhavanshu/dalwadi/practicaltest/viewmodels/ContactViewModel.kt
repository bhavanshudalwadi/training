package com.bhavanshu.dalwadi.practicaltest.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.bhavanshu.dalwadi.practicaltest.models.ContactModel
import com.bhavanshu.dalwadi.practicaltest.repositories.ContactRepository
import kotlinx.coroutines.launch

class ContactViewModel(app: Application, private val contactRepository: ContactRepository): AndroidViewModel(app) {
    fun addContact(contact: ContactModel) = viewModelScope.launch {
        contactRepository.insertContact(contact)
    }

    fun updateContact(contact: ContactModel) = viewModelScope.launch {
        contactRepository.updateContact(contact)
    }

    fun deleteContact(contact: ContactModel) = viewModelScope.launch {
        contactRepository.deleteContact(contact)
    }

    fun getContact(id: Int) = contactRepository.getContactById(id)

    fun getAllContact() = contactRepository.getAllContact()
}