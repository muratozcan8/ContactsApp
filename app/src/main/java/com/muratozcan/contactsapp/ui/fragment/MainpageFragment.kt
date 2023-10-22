package com.muratozcan.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.muratozcan.contactsapp.R
import com.muratozcan.contactsapp.data.entity.Persons
import com.muratozcan.contactsapp.databinding.FragmentMainpageBinding
import com.muratozcan.contactsapp.ui.adapter.PersonAdapter


class MainpageFragment : Fragment() {

    private lateinit var binding: FragmentMainpageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainpageBinding.inflate(inflater, container, false)

        binding.toolbarMainpage.title = "Persons"

        binding.rv.layoutManager = LinearLayoutManager(requireContext())

        val personsList = ArrayList<Persons>()
        val p1 = Persons(1,"Murat", "1111")
        val p2 = Persons(2,"Elif", "2222")
        val p3 = Persons(3,"Ahmet", "3333")
        personsList.add(p1)
        personsList.add(p2)
        personsList.add(p3)

        val personsAdapter = PersonAdapter(requireContext(), personsList)
        binding.rv.adapter = personsAdapter

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.personRegisterPass)
        }

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

    fun search(searchedWord: String){
        Log.e("Person Search", searchedWord)
    }
}