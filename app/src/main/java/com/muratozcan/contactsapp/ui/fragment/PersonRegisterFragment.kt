package com.muratozcan.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.muratozcan.contactsapp.R
import com.muratozcan.contactsapp.databinding.FragmentPersonRegisterBinding

class PersonRegisterFragment : Fragment() {
    private lateinit var binding: FragmentPersonRegisterBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPersonRegisterBinding.inflate(inflater, container, false)

        binding.toolbarPersonRegister.title = "Person Register"

        binding.buttonSave.setOnClickListener {
            val person_name = binding.editTextPersonName.text.toString()
            val person_tel = binding.editTextPersonTel.text.toString()
            save(person_name, person_tel)
        }

        return binding.root
    }

    fun save(person_name:String, person_tel:String){
        Log.e("Person Save", "$person_name - $person_tel")
    }

}