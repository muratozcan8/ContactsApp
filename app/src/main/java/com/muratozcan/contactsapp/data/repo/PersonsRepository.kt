package com.muratozcan.contactsapp.data.repo

import android.util.Log
import com.muratozcan.contactsapp.data.datasource.PersonsDataSource
import com.muratozcan.contactsapp.data.entity.Persons

class PersonsRepository {
    var pds = PersonsDataSource()
    suspend fun save(person_name:String, person_tel:String) = pds.save(person_name, person_tel)
    suspend fun update(person_id: Int, person_name: String, person_tel: String) = pds.update(person_id, person_name, person_tel)
    suspend fun delete(person_id: Int) = pds.delete(person_id)
    suspend fun personsLoad(): List<Persons> = pds.personsLoad()
    suspend fun search(searchedWord: String): List<Persons> = pds.search(searchedWord)
}