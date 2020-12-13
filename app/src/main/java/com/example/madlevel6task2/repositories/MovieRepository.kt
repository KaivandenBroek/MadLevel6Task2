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

    //private var _movie: MutableLiveData<MovieResponse> = MutableLiveData()
    var movie: MutableLiveData<Movie> = MutableLiveData()

    fun showMovie(newMovie: Movie)  {
        movie.value = newMovie
    }

//    suspend fun getPopularMovies(year: String) {
//        try {
//            //timeout the request after 5 seconds
//            val result = withTimeout(5_000) {
//                movieService.getMoviesList(year)
//            }
//            // use gson for data handling
//            val gson = GsonBuilder().create()
//            val newMovies = gson.fromJson(result, MovieResponse::class.java)
//
//            println(newMovies)
//
//            _movie.value = newMovies
//
//        } catch (error: Throwable) {
//            throw MovieSearchError("Unable te retrieve data", error)
//        }
//    }

    class MovieList(val movies: MutableLiveData<List<MovieResponse>>)

    class MovieSearchError(message: String, cause: Throwable) : Throwable(message, cause)
}