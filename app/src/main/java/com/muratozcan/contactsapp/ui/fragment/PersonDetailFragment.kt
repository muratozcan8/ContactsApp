package com.muratozcan.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.muratozcan.contactsapp.R
import com.muratozcan.contactsapp.databinding.FragmentPersonDetailBinding

class PersonDetailFragment : Fragment() {
    private lateinit var binding: FragmentPersonDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_person_detail, container, false)
        binding.personDetailFragment = this
        binding.personDetailToolbarTitle = "Person Detail"

        val bundle: PersonDetailFragmentArgs by navArgs()
        val requestedPerson = bundle.person
        binding.personObject = requestedPerson

        return binding.root
    }

    fun buttonUpdate(person_id: Int, person_name: String, person_tel: String){
        Log.e("Person Update", "$person_id - $person_name - $person_tel")
    }


}