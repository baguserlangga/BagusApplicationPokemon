package com.example.baguspokemonapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.baguspokemonapplication.databinding.ActivityDetailPokemonBinding

class DetailPokemonActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailPokemonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPokemonBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}