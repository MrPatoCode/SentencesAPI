package com.paulinoeme.sentencesapi.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.paulinoeme.sentencesapi.databinding.ActivityMainBinding
import com.paulinoeme.sentencesapi.viewmodel.SentencesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val sentenceModel:SentencesViewModel by viewModels()
    private var explanation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sentenceModel.getSentenceRandom()

        sentenceModel.sentenceModel.observe(this, Observer {
            sentenceModel.intoImage(it.image, binding.ivPhoto)
            binding.tvAuthor.text = it.author
            binding.tvSentence.text = it.sentence
            explanation = it.explanation
        })

        binding.viewContainer.setOnClickListener {
            sentenceModel.getSentenceRandom()
        }

        binding.btnExplanation.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("explanation", explanation)
            startActivity(intent)
        }
    }
}