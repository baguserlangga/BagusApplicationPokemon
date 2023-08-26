package com.example.baguspokemonapplication

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.baguspokemonapplication.adapter.PokemonAdapter
import com.example.baguspokemonapplication.databinding.ActivityMainBinding
import com.example.baguspokemonapplication.model.PokemonListModel
import com.example.baguspokemonapplication.model.ResponseListPokemon
import com.example.baguspokemonapplication.service.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding  : ActivityMainBinding

    private lateinit var pokemonAdapter: PokemonAdapter

    val listPokemonModel  = ArrayList<PokemonListModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        prepareRecyclerView()
        getPokemonlist()
        setContentView(binding.root)
    }
    private fun prepareRecyclerView() {
        var lm = LinearLayoutManager(this@MainActivity)
        pokemonAdapter = PokemonAdapter(this@MainActivity,listPokemonModel)
        binding.mRecycle.setHasFixedSize(true)
        binding.mRecycle.layoutManager = lm
        binding.mRecycle.adapter = pokemonAdapter
    }

    fun getPokemonlist() {

        RetrofitInstance.api.getPokemonList().enqueue(object  :
            Callback<ResponseListPokemon> {
            override fun onResponse(call: Call<ResponseListPokemon>, response: Response<ResponseListPokemon>) {
                if (response.body()!=null){

                    listPokemonModel.addAll(response.body()!!.results)


                    Log.d(ContentValues.TAG, "inionResponse: "  + listPokemonModel)
                    pokemonAdapter.notifyDataSetChanged()
                }
                else{
                    Log.d("TAGihan", response.code().toString())

                }
            }
            override fun onFailure(call: Call<ResponseListPokemon>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                Log.d("TAGihan", t.message.toString())
            }
        })
    }
}