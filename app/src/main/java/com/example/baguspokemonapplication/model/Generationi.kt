package com.example.baguspokemonapplication.model

import com.google.gson.annotations.SerializedName

class Generationi (
    @SerializedName("red-blue" ) var redblue : Redblue? = Redblue(),
@SerializedName("yellow"   ) var yellow   : Yellow?   = Yellow()
        )
