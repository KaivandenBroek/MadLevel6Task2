package com.example.madlevel6task2.repositories

import androidx.lifecycle.MutableLiveData
import com.example.madlevel6task2.MovieService
import com.example.madlevel6task2.ServiceBuilder
import com.example.madlevel6task2.model.Movie
import com.example.madlevel6task2.model.MovieResponse
import com.google.gson.GsonBuilder
import kotlinx.coroutines.withTimeout

class MovieRepository {
    private val movieService: MovieService = ServiceBuilder.createApi()
    val movieData: MutableLiveData<MovieResponse> = MutableLiveData()

    var movie: MutableLiveData<Movie> = MutableLiveData()

    fun showMovie(newMovie: Movie) {
        movie.value = newMovie
    }

    suspend fun getMovies(year: String) {

        try {
            val result = movieService.getMoviesList(year)
            movieData.value = result

        } catch (error: Throwable) {
            throw Error(
                "Something went wrong while fetching API", error
            );
        }

    }

    class MovieSearchError(message: String, cause: Throwable) : Throwable(message, cause)
}