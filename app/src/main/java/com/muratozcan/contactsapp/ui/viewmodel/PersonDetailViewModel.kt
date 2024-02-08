package com.muratozcan.contactsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.muratozcan.contactsapp.data.repo.PersonsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonDetailViewModel @Inject constructor(var prepo:PersonsRepository) : ViewModel() {

    fun update(person_id: Int, person_name: String, person_tel: String){
        CoroutineScope(Dispatchers.Main).launch {
            prepo.update(person_id, person_name, person_tel)
        }
    }
}