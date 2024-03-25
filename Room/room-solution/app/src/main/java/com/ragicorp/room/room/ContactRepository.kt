package com.ragicorp.room.room

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.ragicorp.room.Contact
import java.util.*

class ContactRepository(context: Context) {
    private val db = Room.databaseBuilder(
        context,
        ContactDatabase::class.java, "contactDb"
    ).build()

    fun getAll(): Flow<List<Contact>> {
        return db.contactDao()
            .getAll()
            .map { contacts ->
                contacts.map { contactFromDb(it) }
            }
    }

    suspend fun insert(contact: Contact) {
        db.contactDao().insert(contactToDb(contact))
    }

    suspend fun delete(contact: Contact) {
        db.contactDao().delete(contactToDb(contact))
    }

    private fun contactToDb(contact: Contact) = ContactDb(
        id = contact.id.toString(),
        name = contact.name,
        phoneNumber = contact.phoneNumber
    )

    private fun contactFromDb(contact: ContactDb) = Contact(
        id = UUID.fromString(contact.id),
        name = contact.name,
        phoneNumber = contact.phoneNumber
    )
}