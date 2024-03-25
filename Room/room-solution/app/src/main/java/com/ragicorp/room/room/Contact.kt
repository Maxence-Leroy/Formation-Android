package com.ragicorp.room.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class ContactDb(
    @PrimaryKey val id: String,
    val name: String,
    @ColumnInfo(name = "phone_number") val phoneNumber: String
)