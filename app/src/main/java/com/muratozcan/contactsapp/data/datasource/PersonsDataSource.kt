package com.muratozcan.contactsapp.data.datasource

import android.util.Log
import com.muratozcan.contactsapp.data.entity.Persons
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonsDataSource {

    suspend fun personsLoad(): List<Persons> =
        withContext(Dispatchers.IO){
            val personsList = ArrayList<Persons>()
            val p1 = Persons(1,"Murat", "1111")
            val p2 = Persons(2,"Elif", "2222")
            val p3 = Persons(3,"Ahmet", "3333")
            personsList.add(p1)
            personsList.add(p2)
            personsList.add(p3)
            return@withContext personsList
        }
    suspend fun save(person_name:String, person_tel:String){
        Log.e("Person Save", "$person_name - $person_tel")
    }

    suspend fun update(person_id: Int, person_name: String, person_tel: String){
        Log.e("Person Update", "$person_id - $person_name - $person_tel")
    }

    suspend fun delete(person_id: Int){
        Log.e("Person Delete", person_id.toString())
    }

    suspend fun search(searchedWord: String): List<Persons> =
        withContext(Dispatchers.IO){
            val personsList = ArrayList<Persons>()
            val p2 = Persons(2,"Elif", "2222")
            personsList.add(p2)
            return@withContext personsList
        }
}