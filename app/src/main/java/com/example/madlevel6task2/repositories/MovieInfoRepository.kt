package com.example.madlevel6task2.repositories

import androidx.lifecycle.MutableLiveData
import com.example.madlevel6task2.MovieService
import com.example.madlevel6task2.ServiceBuilder
import com.example.madlevel6task2.model.MovieResponse

class MovieInfoRepository {

    private val movieService: MovieService = ServiceBuilder.createApi()
    val movieData: MutableLiveData<MovieResponse> = MutableLiveData()
    //private lateinit var currentYear: String;

    suspend fun getMovies(year: String)  {

        //currentYear = year

        try {
            val result = movieService.getMoviesList(year)
            movieData.value = result

        } catch (error: Throwable) {
            throw Error(
                "Something went wrong while fetching API"
                , error);
        }

    }
}