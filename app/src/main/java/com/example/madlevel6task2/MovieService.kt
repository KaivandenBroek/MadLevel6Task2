package com.example.madlevel6task2


import retrofit2.http.GET

interface MovieService {

    @GET("/movie/popular")
    suspend fun getMoviesList () : List<Movie>
}