package com.paulinoeme.sentencesapi.data

import com.paulinoeme.sentencesapi.data.model.SentenceModel
import com.paulinoeme.sentencesapi.data.model.SentencesProvider
import com.paulinoeme.sentencesapi.data.network.SentencesService

class SentencesRepository() {
    private val api = SentencesService()

    suspend fun getAllSentences(): List<SentenceModel>{
        val sentences: List<SentenceModel> = api.getSentences()
        SentencesProvider.sentences = sentences
        return sentences
    }
}