package com.bhavanshu.dalwadi.practicaltest.repositories

import com.bhavanshu.dalwadi.practicaltest.models.ContactModel
import com.bhavanshu.dalwadi.practicaltest.database.CashMangemantDatabase

class ContactRepository(private val db: CashMangemantDatabase) {
    suspend fun insertContact(contact: ContactModel) = db.getContactDao().insertContact(contact)
    suspend fun updateContact(contact: ContactModel) = db.getContactDao().updateContact(contact)
    suspend fun deleteContact(contact: ContactModel) = db.getContactDao().deleteContact(contact)

    fun getAllContact() = db.getContactDao().getAllContact()
    fun getContactById(id: Int) = db.getContactDao().getContactById(id)
}