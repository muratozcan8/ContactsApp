package com.muratozcan.contactsapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.muratozcan.contactsapp.data.entity.Persons

@Dao
interface PersonsDao {
    @Query("SELECT * FROM Persons")
    suspend fun personsLoad() : List<Persons>

    @Insert
    suspend fun save(person: Persons)

    @Update
    suspend fun update(person: Persons)

    @Delete
    suspend fun delete(person: Persons)

    @Query("SELECT * FROM Persons WHERE person_name like '%' || :searchedWord || '%'")
    suspend fun search(searchedWord: String) : List<Persons>
}