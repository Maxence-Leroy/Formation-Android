package com.ragicorp.room.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ContactDb::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
}