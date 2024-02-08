package com.muratozcan.contactsapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muratozcan.contactsapp.data.entity.Persons
import com.muratozcan.contactsapp.data.repo.PersonsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainpageViewModel @Inject constructor(var prepo:PersonsRepository) : ViewModel() {
    var personsList = MutableLiveData<List<Persons>>()

    init {
        personsLoad()
    }

    fun delete(person_id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            prepo.delete(person_id)
            personsLoad()
        }
    }
    fun personsLoad() {
        CoroutineScope(Dispatchers.Main).launch {
            personsList.value = prepo.personsLoad()
        }
    }

    fun search(searchedWord: String){
        CoroutineScope(Dispatchers.Main).launch {
            personsList.value = prepo.search(searchedWord)
        }
    }
}