package com.example.baguspokemonapplication.model

import com.google.gson.annotations.SerializedName

data class PokemonListModel (
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("url"  ) var url  : String? = null

        )
