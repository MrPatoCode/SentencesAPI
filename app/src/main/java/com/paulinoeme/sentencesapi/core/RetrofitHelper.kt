package com.paulinoeme.sentencesapi.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://raw.githubusercontent.com/MrPatoCode/JSONs/main/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}