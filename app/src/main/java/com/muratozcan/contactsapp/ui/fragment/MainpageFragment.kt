package com.muratozcan.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.muratozcan.contactsapp.R
import com.muratozcan.contactsapp.data.entity.Persons
import com.muratozcan.contactsapp.databinding.FragmentMainpageBinding
import com.muratozcan.contactsapp.ui.adapter.PersonAdapter
import com.muratozcan.contactsapp.ui.viewmodel.MainpageViewModel
import com.muratozcan.contactsapp.ui.viewmodel.PersonRegisterViewModel


class MainpageFragment : Fragment() {

    private lateinit var binding: FragmentMainpageBinding
    private lateinit var viewModel: MainpageViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_mainpage, container, false)
        binding.mainpageFragment = this
        binding.mainpageToolbarTitle = "Persons"

        viewModel.personsList.observe(viewLifecycleOwner){
            val personsAdapter = PersonAdapter(requireContext(), it, viewModel)
            binding.personsAdapter = personsAdapter
        }



        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.search(query)
                return true
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainpageViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabClick(it:View){
        Navigation.findNavController(it).navigate(R.id.personRegisterPass)
    }

    override fun onResume() {
        super.onResume()
        viewModel.personsLoad()
    }
}