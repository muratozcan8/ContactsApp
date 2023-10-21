package com.muratozcan.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.muratozcan.contactsapp.R
import com.muratozcan.contactsapp.databinding.FragmentPersonDetailBinding

class PersonDetailFragment : Fragment() {
    private lateinit var binding: FragmentPersonDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPersonDetailBinding.inflate(inflater, container, false)

        binding.toolbarPersonDetail.title = "Person Detail"

        val bundle: PersonDetailFragmentArgs by navArgs()
        val requestedPerson = bundle.person

        binding.editTextPersonName.setText(requestedPerson.person_name)
        binding.editTextPersonTel.setText(requestedPerson.person_tel)

        binding.buttonUpdate.setOnClickListener {
            val person_name = binding.editTextPersonName.text.toString()
            val person_tel = binding.editTextPersonTel.text.toString()
            update(requestedPerson.person_id, person_name, person_tel)
        }

        return binding.root
    }

    fun update(person_id: Int, person_name: String, person_tel: String){
        Log.e("Person Update", "$person_id - $person_name - $person_tel")
    }


}