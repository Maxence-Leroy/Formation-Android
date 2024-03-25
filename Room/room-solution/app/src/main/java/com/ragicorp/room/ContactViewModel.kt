package com.ragicorp.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ragicorp.room.room.ContactRepository
import kotlinx.coroutines.launch

class ContactViewModel(private val repository: ContactRepository): ViewModel() {
    val contacts = repository.getAll()

    fun insertContact(contact: Contact) {
        viewModelScope.launch {
            repository.insert(contact)
        }
    }

    fun deleteContact(contact: Contact) {
        viewModelScope.launch {
            repository.delete(contact)
        }
    }
}