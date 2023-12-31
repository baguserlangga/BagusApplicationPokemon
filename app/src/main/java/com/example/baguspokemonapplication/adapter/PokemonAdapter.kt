package com.example.baguspokemonapplication.adapter

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.baguspokemonapplication.DetailPokemonActivity
import com.example.baguspokemonapplication.R
import com.example.baguspokemonapplication.model.PokemonListModel
import java.util.Random


class PokemonAdapter (private val mList: List<PokemonListModel>) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

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
        holder.textViewNamaPokemon.text = ItemsViewModel.name
        holder.textViewNamaPokemon.setOnClickListener{
            val intent = Intent(holder.textViewNamaPokemon.context,DetailPokemonActivity::class.java)
            intent.putExtra("namaPokemon", ItemsViewModel.name)
            holder.textViewNamaPokemon.context.startActivity(intent)
        }
        val rnd = Random()
        val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        holder.textViewNamaPokemon.setBackgroundColor(color)

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