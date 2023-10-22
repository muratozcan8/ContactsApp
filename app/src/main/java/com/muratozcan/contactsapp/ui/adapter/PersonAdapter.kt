package com.muratozcan.contactsapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.muratozcan.contactsapp.data.entity.Persons
import com.muratozcan.contactsapp.databinding.CardDesignBinding
import com.muratozcan.contactsapp.ui.fragment.MainpageFragmentDirections

class PersonAdapter(var mContext: Context, var personsList: List<Persons>) : RecyclerView.Adapter<PersonAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var design: CardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val person = personsList[position]
        val d = holder.design

        d.textViewPersonName.text = person.person_name
        d.textViewPersonTel.text = person.person_tel

        d.cardViewLine.setOnClickListener{
            val pass = MainpageFragmentDirections.personDetailPass(person = person)
            Navigation.findNavController(it).navigate(pass)
        }

        d.imageViewClear.setOnClickListener {
            Snackbar.make(it, "Do you want to delete ${person.person_name} ?", Snackbar.LENGTH_SHORT)
                .setAction("YES"){
                    delete(person.person_id)
                }
                .show()
        }
    }

    override fun getItemCount(): Int {
        return personsList.size
    }

    fun delete(person_id: Int){
        Log.e("Person Delete", person_id.toString())
    }

}