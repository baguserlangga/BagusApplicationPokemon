package com.example.baguspokemonapplication.model

import com.google.gson.annotations.SerializedName

data class ResponseListPokemon(
    @SerializedName("count"    ) var count    : Int?               = null,
    @SerializedName("next"     ) var next     : String?            = null,
    @SerializedName("previous" ) var previous : String?            = null,
    @SerializedName("results"  ) var results  : ArrayList<PokemonListModel> = arrayListOf()
)