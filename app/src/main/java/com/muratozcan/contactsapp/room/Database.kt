package com.muratozcan.contactsapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.muratozcan.contactsapp.data.entity.Persons

@Database(entities = [Persons::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun getPersonsDao() : PersonsDao

}