package com.example.madlevel6task2.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.madlevel6task2.repositories.MovieInfoRepository
import kotlinx.coroutines.launch

class MovieInfoViewModel (application: Application) : AndroidViewModel(application) {

    private val movieInfoRepository = MovieInfoRepository()
    val movieData = movieInfoRepository.movieData

    /**
     * Initialised API call and fetches a list of movies from a certain
     * year.
     * @param [String] year
     */
    fun getMoviesByYear(year: String) {
        viewModelScope.launch {
            movieInfoRepository.getMovies(year)
        }
    }
}