package com.paulinoeme.sentencesapi.di

import com.paulinoeme.sentencesapi.data.network.SentencesClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/MrPatoCode/JSONs/main/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideSentences(retrofit: Retrofit):SentencesClient{
        return retrofit.create(SentencesClient ::class.java)
    }

}