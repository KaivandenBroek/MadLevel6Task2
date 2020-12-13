package com.example.madlevel6task2.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.madlevel6task2.model.Movie
import com.example.madlevel6task2.repositories.MovieRepository
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
//    fun getMovieList(year: String) {
//        viewModelScope.launch {
//            try {
//                movieRepo.getPopularMovies(year)
//            } catch (error: MovieRepository.MovieSearchError) {
//                _errorText.value = error.message
//                Log.e("Movie error", error.cause.toString())
//            }
//
//        }
//    }

    /**
     * This function runs whenever someone clicks on a movie they
     * want to view in detail. The function that is being called
     * will store the selected movie into a livedata object
     * that is then being observed by another function that will
     * actually fill in all data into the fragment.
     */
    fun setMovie(newMovie: Movie) {
        viewModelScope.launch {
            movieRepo.showMovie(newMovie)
        }
    }
}