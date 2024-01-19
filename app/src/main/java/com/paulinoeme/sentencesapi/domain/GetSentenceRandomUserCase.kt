package com.paulinoeme.sentencesapi.domain

import com.paulinoeme.sentencesapi.data.SentencesRepository
import com.paulinoeme.sentencesapi.data.model.SentenceModel

class GetSentenceRandomUserCase {
    private val repository = SentencesRepository()

    suspend operator fun invoke(): SentenceModel? {
        val sentences = repository.getAllSentences()
        if (!sentences.isNullOrEmpty()) {
            var randomNumber = (sentences.indices).random()
            return sentences[randomNumber]
        }
        return null
    }

}