package com.battermind.aug2024bootcamp.binding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.battermind.aug2024bootcamp.R
import com.battermind.aug2024bootcamp.databinding.ActivityBindingBinding

class BindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /* for testing */
    }
}