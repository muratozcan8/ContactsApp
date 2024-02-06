package com.muratozcan.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.muratozcan.contactsapp.R
import com.muratozcan.contactsapp.databinding.FragmentPersonRegisterBinding
import com.muratozcan.contactsapp.ui.viewmodel.MainpageViewModel
import com.muratozcan.contactsapp.ui.viewmodel.PersonRegisterViewModel

class PersonRegisterFragment : Fragment() {
    private lateinit var binding: FragmentPersonRegisterBinding
    private lateinit var viewModel: PersonRegisterViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_person_register, container, false)
        binding.personRegisterFragment = this
        binding.personRegisterToolbarTitle = "Person Register"
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: PersonRegisterViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonSave(person_name:String, person_tel:String){
        viewModel.save(person_name, person_tel)
    }

}