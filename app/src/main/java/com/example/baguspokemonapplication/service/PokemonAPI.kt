package com.example.baguspokemonapplication.service

import com.example.baguspokemonapplication.model.PokemonDetailModel
import com.example.baguspokemonapplication.model.ResponseListPokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonAPI {

    @GET("pokemon/")
    fun getPokemonList() : Call<ResponseListPokemon>

    @GET("pokemon/{id}/")
    fun getPokemonDetail(@Path("id") movie_id:String) : Call<PokemonDetailModel>
}