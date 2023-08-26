package com.example.baguspokemonapplication.adapter

import android.content.Context
import android.content.Intent
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baguspokemonapplication.DetailPokemonActivity
import com.example.baguspokemonapplication.databinding.ItemListPokemonBinding
import com.example.baguspokemonapplication.model.PokemonListModel

class PokemonAdapter (val context: Context, val result : ArrayList <PokemonListModel>): RecyclerView.Adapter<PokemonAdapter.ViewHolder>(){




//    fun setMovieList(movieList: List<Results>) {
//        this.movieList = movieList as ArrayList<Results>
//        notifyDataSetChanged()
//    }

    class ViewHolder(val binding: ItemListPokemonBinding) : RecyclerView.ViewHolder(binding.root) {
//        val
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListPokemonBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item  = result[position]
//        holder.binding.textViewNamaPokemon.setOnClickListener{
//            val intent = Intent(context, DetailPokemonActivity::class.java)
//                intent.putExtra("idMovie", item.url.toString())
//            context.startActivity(intent)
//        }

        holder.binding.textViewNamaPokemon.text = item.name +" "
    }

    override fun getItemCount(): Int {
        return result.size
    }
}