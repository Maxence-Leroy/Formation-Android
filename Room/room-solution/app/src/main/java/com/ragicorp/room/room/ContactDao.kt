package com.ragicorp.room.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Query("SELECT * FROM contact")
    fun getAll(): Flow<List<ContactDb>>

    @Insert
    suspend fun insert(contact: ContactDb)

    @Delete
    suspend fun delete(contact: ContactDb)
}