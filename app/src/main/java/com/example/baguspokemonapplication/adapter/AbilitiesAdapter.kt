package com.example.baguspokemonapplication.adapter

import android.content.Context
import android.content.Intent
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.baguspokemonapplication.DetailPokemonActivity
import com.example.baguspokemonapplication.R
import com.example.baguspokemonapplication.databinding.ItemListPokemonBinding
import com.example.baguspokemonapplication.model.Abilities
import com.example.baguspokemonapplication.model.PokemonListModel

class AbilitiesAdapter (private val mList: List<Abilities>) : RecyclerView.Adapter<AbilitiesAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_pokemon, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
//        holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.textViewNamaPokemon.text = ItemsViewModel.ability!!.name

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
//        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textViewNamaPokemon: TextView = itemView.findViewById(R.id.textViewNamaPokemon)
    }
}