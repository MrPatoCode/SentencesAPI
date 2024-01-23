package com.paulinoeme.sentencesapi.data

import com.paulinoeme.sentencesapi.data.model.SentenceModel
import com.paulinoeme.sentencesapi.data.model.SentencesProvider
import com.paulinoeme.sentencesapi.data.network.SentencesService
import javax.inject.Inject

class SentencesRepository @Inject constructor(
    private val api:SentencesService,
    private val sentencesProvider: SentencesProvider
) {
    suspend fun getAllSentences(): List<SentenceModel>{
        val sentences: List<SentenceModel> = api.getSentences()
        sentencesProvider.sentences = sentences
        return sentences
    }
}