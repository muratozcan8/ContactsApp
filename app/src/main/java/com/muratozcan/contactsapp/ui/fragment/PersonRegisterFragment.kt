package com.muratozcan.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.muratozcan.contactsapp.R
import com.muratozcan.contactsapp.databinding.FragmentPersonRegisterBinding

class PersonRegisterFragment : Fragment() {
    private lateinit var binding: FragmentPersonRegisterBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_person_register, container, false)
        binding.personRegisterFragment = this
        binding.personRegisterToolbarTitle = "Person Register"
        return binding.root
    }

    fun buttonSave(person_name:String, person_tel:String){
        Log.e("Person Save", "$person_name - $person_tel")
    }

}