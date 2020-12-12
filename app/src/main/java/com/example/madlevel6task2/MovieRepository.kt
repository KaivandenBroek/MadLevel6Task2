package com.example.madlevel6task2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.withTimeout

class MovieRepository {
    private val movieService: MovieService = ServiceBuilder.createApi()

    private val _movie: MutableLiveData<List<Movie>> = MutableLiveData()

    /**
     * Expose non MutableLiveData via getter
     * Encapsulation :)
     */
    val movie: LiveData<List<Movie>>
    get() = _movie

    suspend fun getPopularMovies() {
        try {
            //timeout the request after 5 seconds
            val result = withTimeout(5_000) {
                movieService.getMoviesList()
            }
            _movie.value = result
        } catch (error: Throwable) {
            throw MovieSearchError("Unable te retrieve data", error)
        }
    }
    class MovieSearchError(message: String, cause: Throwable) : Throwable(message, cause)
}