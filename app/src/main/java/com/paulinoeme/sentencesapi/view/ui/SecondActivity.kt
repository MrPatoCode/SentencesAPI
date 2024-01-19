package com.paulinoeme.sentencesapi.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.paulinoeme.sentencesapi.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val explanation = intent.getStringExtra("explanation")

        binding.tvExplanation.text = explanation
    }
}