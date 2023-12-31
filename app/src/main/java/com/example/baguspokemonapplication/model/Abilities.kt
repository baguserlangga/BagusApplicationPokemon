package com.example.baguspokemonapplication.model

import com.google.gson.annotations.SerializedName

class Abilities (
    @SerializedName("ability"   ) var ability  : Ability? = Ability(),
    @SerializedName("is_hidden" ) var isHidden : Boolean? = null,
    @SerializedName("slot"      ) var slot     : Int?     = null
        )
