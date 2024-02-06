package com.muratozcan.contactsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.muratozcan.contactsapp.data.repo.PersonsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonRegisterViewModel : ViewModel() {
    var prepo = PersonsRepository()
    fun save(person_name:String, person_tel:String){
        CoroutineScope(Dispatchers.Main).launch {
            prepo.save(person_name, person_tel)
        }
    }
}