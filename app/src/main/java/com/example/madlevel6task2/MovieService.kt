package com.example.madlevel6task2


import androidx.lifecycle.MutableLiveData
import com.example.madlevel6task2.model.Movie
import com.example.madlevel6task2.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular?api_key=4e3a4dca7cbfff7bfd8ac3c401a0b5a3&language=en-US&page=1")
    //suspend fun getMoviesList (@Query("year") year: String) : MutableLiveData<List<Movie>>
    suspend fun getMoviesList (@Query("year") year: String) : MovieResponse
}