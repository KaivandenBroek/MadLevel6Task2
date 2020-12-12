package com.example.madlevel6task2

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    private val movieRepo = MovieRepository()

    val movie = movieRepo.movie
    private val _errorText: MutableLiveData<String> = MutableLiveData()

    /**
     * Expose non MutableLiveData via getter
     * errorText can be observed from view for error showing
     * Encapsulation :)
     */
    val errorText: LiveData<String>
        get() = _errorText
    fun getMovieList(year: String) {
        viewModelScope.launch {
            try {
                movieRepo.getPopularMovies(year)
            } catch (error: MovieRepository.MovieSearchError) {
                _errorText.value = error.message
                Log.e("Movie error", error.cause.toString())
            }

        }
    }
}