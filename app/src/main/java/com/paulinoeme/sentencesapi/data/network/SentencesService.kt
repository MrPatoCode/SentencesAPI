package com.paulinoeme.sentencesapi.data.network

import com.paulinoeme.sentencesapi.data.model.SentenceModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class SentencesService @Inject constructor(
    private val api:SentencesClient
) {

    suspend fun getSentences(): List<SentenceModel>{
        return withContext(Dispatchers.IO){
            val response: Response<List<SentenceModel>> = api.getAllSentences()
                response.body()?: emptyList()
        }
    }
}