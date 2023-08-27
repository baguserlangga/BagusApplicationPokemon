package com.example.baguspokemonapplication.model

import com.google.gson.annotations.SerializedName

class Ability (
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("url"  ) var url  : String? = null)
