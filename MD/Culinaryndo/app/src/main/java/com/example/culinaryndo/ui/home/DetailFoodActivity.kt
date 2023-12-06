package com.example.culinaryndo.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.culinaryndo.R
import com.example.culinaryndo.databinding.ActivityDetailFoodBinding

class DetailFoodActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailFoodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }

    }
}