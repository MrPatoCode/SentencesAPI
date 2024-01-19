package com.paulinoeme.sentencesapi.data.network

import com.paulinoeme.sentencesapi.data.model.SentenceModel
import retrofit2.Response
import retrofit2.http.GET

interface SentencesClient {
    @GET("sentences.json")
    suspend fun getAllSentences(): Response<List<SentenceModel>>

}