package com.example.madlevel6task2

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder { //https://api.themoviedb.org/3/
    private const val URL = "https://api.themoviedb.org/3/"
//    //create http client
//    private val okHttp = OkHttpClient.Builder()
//
//    //retrofit builder
//    private val builder = Retrofit.Builder().baseUrl(URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .client(okHttp.build())
//
//    //create retrofit instance
//    private val retrofit = builder.build()
//
//    //we will use this class to create an anonymous inner class function that
//    //implements Country service Interface
//
//    fun <T> buildService (serviceType :Class<T>):T{
//        return retrofit.create(serviceType)
//    }

    fun createApi(): MovieService{
        // Create an OkHttpClient to be able to make a log of the network traffic
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

        // Create the Retrofit instance
        val triviaApi = Retrofit.Builder()
                .baseUrl(URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        // Return the Retrofit TriviaApiService
        return triviaApi.create(MovieService::class.java)
    }
}