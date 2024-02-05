package com.muratozcan.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.muratozcan.contactsapp.R
import com.muratozcan.contactsapp.data.entity.Persons
import com.muratozcan.contactsapp.databinding.FragmentMainpageBinding
import com.muratozcan.contactsapp.ui.adapter.PersonAdapter


class MainpageFragment : Fragment() {

    private lateinit var binding: FragmentMainpageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_mainpage, container, false)
        binding.mainpageFragment = this
        binding.mainpageToolbarTitle = "Persons"

        val personsList = ArrayList<Persons>()
        val p1 = Persons(1,"Murat", "1111")
        val p2 = Persons(2,"Elif", "2222")
        val p3 = Persons(3,"Ahmet", "3333")
        personsList.add(p1)
        personsList.add(p2)
        personsList.add(p3)

        val personsAdapter = PersonAdapter(requireContext(), personsList)
        binding.personsAdapter = personsAdapter

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                search(query)
                return true
            }
        })

        return binding.root
    }

    fun fabClick(it:View){
        Navigation.findNavController(it).navigate(R.id.personRegisterPass)
    }

    fun search(searchedWord: String){
        Log.e("Person Search", searchedWord)
    }
}