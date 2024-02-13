package com.muratozcan.contactsapp.data.datasource

import android.util.Log
import com.muratozcan.contactsapp.data.entity.Persons
import com.muratozcan.contactsapp.room.PersonsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonsDataSource(var pdao: PersonsDao) {

    suspend fun personsLoad(): List<Persons> =
        withContext(Dispatchers.IO){
            return@withContext pdao.personsLoad()
        }
    suspend fun save(person_name:String, person_tel:String){
        val newPerson = Persons(0, person_name, person_tel)
        pdao.save(newPerson)
        Log.e("Person Save", "$person_name - $person_tel")
    }

    suspend fun update(person_id: Int, person_name: String, person_tel: String){
        val updatedPerson = Persons(person_id, person_name, person_tel)
        pdao.update(updatedPerson)
        Log.e("Person Update", "$person_id - $person_name - $person_tel")
    }

    suspend fun delete(person_id: Int){
        val deletedPerson = Persons(person_id, "", "")
        pdao.delete(deletedPerson)
        Log.e("Person Delete", person_id.toString())
    }

    suspend fun search(searchedWord: String): List<Persons> =
        withContext(Dispatchers.IO){
            return@withContext pdao.search(searchedWord)
        }
}