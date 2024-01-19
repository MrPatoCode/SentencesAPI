package com.paulinoeme.sentencesapi.data.network

import com.paulinoeme.sentencesapi.core.RetrofitHelper
import com.paulinoeme.sentencesapi.data.model.SentenceModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class SentencesService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getSentences(): List<SentenceModel>{
        return withContext(Dispatchers.IO){
            val response: Response<List<SentenceModel>> = retrofit.create(SentencesClient::class.java)
                .getAllSentences()
                response.body()?: emptyList()
        }
    }
}