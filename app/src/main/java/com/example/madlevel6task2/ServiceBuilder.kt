package com.example.madlevel6task2

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val URL = "https://api.themoviedb.org/3/"

    fun createApi(): MovieService{
        // Create an OkHttpClient to be able to make a log of the network traffic
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

        // Create the Retrofit instance
        val movieApi = Retrofit.Builder()
                .baseUrl(URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        // Return the Retrofit TriviaApiService
        return movieApi.create(MovieService::class.java)
    }
}