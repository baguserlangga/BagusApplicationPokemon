package com.example.baguspokemonapplication.service

import com.example.baguspokemonapplication.model.ResponseListPokemon
import retrofit2.Call
import retrofit2.http.GET

interface PokemonAPI {

    @GET("pokemon/")
    fun getPokemonList() : Call<ResponseListPokemon>
}