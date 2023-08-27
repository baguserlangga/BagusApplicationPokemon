package com.example.baguspokemonapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.baguspokemonapplication.adapter.AbilitiesAdapter
import com.example.baguspokemonapplication.adapter.PokemonAdapter
import com.example.baguspokemonapplication.databinding.ActivityDetailPokemonBinding
import com.example.baguspokemonapplication.model.PokemonDetailModel
import com.example.baguspokemonapplication.service.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailPokemonActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailPokemonBinding
    private lateinit var abilitiesAdapter: AbilitiesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPokemonBinding.inflate(layoutInflater)

        checkdata()
        val nama =intent.getStringExtra("namaPokemon").toString()
        getPokemonlist(nama)
        setContentView(binding.root)
    }

    fun checkdata()
    {
        binding.imageView.visibility = View.GONE
        binding.textViewNamaPokemon.visibility = View.GONE
        binding.textView3.visibility = View.GONE
        binding.mRecycleView.visibility = View.GONE

    }
    fun tampilData()
    {
        binding.imageView.visibility = View.VISIBLE
        binding.textViewNamaPokemon.visibility = View.VISIBLE
        binding.textView3.visibility = View.VISIBLE
        binding.mRecycleView.visibility = View.VISIBLE
    }
    fun getPokemonlist(name:String) {
        RetrofitInstance.api.getPokemonDetail(name).enqueue(object  :
            Callback<PokemonDetailModel> {
            override fun onResponse(call: Call<PokemonDetailModel>, response: Response<PokemonDetailModel>) {
                if (response.body()!=null){
                    binding.progressBar.visibility = View.GONE
                    tampilData()
                    val item = response.body()!!
                    binding.textViewNamaPokemon.text = response.body()!!.name
                    Glide.with(binding.imageView)
                        .load(item.sprites!!.other!!.home!!.front_default)
                        .into(binding.imageView)
                    var lm = LinearLayoutManager(this@DetailPokemonActivity)
                    abilitiesAdapter = AbilitiesAdapter(item.abilities)
                    binding.mRecycleView.setHasFixedSize(true)
                    binding.mRecycleView.layoutManager = lm
                    binding.mRecycleView.adapter = abilitiesAdapter

                }
                else{
                    Log.d("TAGihan", response.code().toString())

                }
            }
            override fun onFailure(call: Call<PokemonDetailModel>, t: Throwable) {
                Toast.makeText(this@DetailPokemonActivity, "Error", Toast.LENGTH_SHORT).show()
                Log.d("TAGihan", t.message.toString())
            }
        })

    }
}