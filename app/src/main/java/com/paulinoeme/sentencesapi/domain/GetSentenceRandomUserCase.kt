package com.paulinoeme.sentencesapi.domain

import com.paulinoeme.sentencesapi.data.SentencesRepository
import com.paulinoeme.sentencesapi.data.model.SentenceModel
import javax.inject.Inject

class GetSentenceRandomUserCase @Inject constructor(
    private val repository: SentencesRepository
) {
    suspend operator fun invoke(): SentenceModel? {
        val sentences = repository.getAllSentences()
        if (!sentences.isNullOrEmpty()) {
            var randomNumber = (sentences.indices).random()
            return sentences[randomNumber]
        }
        return null
    }

}