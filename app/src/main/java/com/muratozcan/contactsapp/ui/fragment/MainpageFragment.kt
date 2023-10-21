package com.muratozcan.contactsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.muratozcan.contactsapp.R
import com.muratozcan.contactsapp.data.entity.Persons
import com.muratozcan.contactsapp.databinding.FragmentMainpageBinding


class MainpageFragment : Fragment() {

    private lateinit var binding: FragmentMainpageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainpageBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.personRegisterPass)
        }

        binding.buttonDetail.setOnClickListener {
            val person = Persons(1, "Murat", "1111")
            val pass = MainpageFragmentDirections.personDetailPass(person = person)
            Navigation.findNavController(it).navigate(pass)
        }

        return binding.root
    }
}