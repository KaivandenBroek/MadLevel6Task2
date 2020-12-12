package com.example.madlevel6task2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListFragment : Fragment() {
    private lateinit var viewModel: MovieViewModel
    private lateinit var movies: ArrayList<Movie>
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var viewManager: GridLayoutManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSearch.setOnClickListener {
            viewModel.getMovieList()
        }
        initViews()
    }

    private fun initViews() {
        movies = arrayListOf()
        movieAdapter = MovieAdapter(movies, requireContext())
        viewManager = GridLayoutManager(activity, 2)
        //manager?
        gvMovies.adapter = movieAdapter
        observeMovies()
    }

    private fun observeMovies() {
        viewModel.movie.observe(viewLifecycleOwner, { movie ->
            movies.clear()
            movies.addAll(movie)
            movieAdapter.notifyDataSetChanged()
        })
        // Observe the error message.
        viewModel.errorText.observe(viewLifecycleOwner, {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })
    }

}

// get popular movies by release date
// use id for photo and put image in list with glide

// API:KEY: 4e3a4dca7cbfff7bfd8ac3c401a0b5a3

// JUST ADD YEAR AFTER URL IN MOVIESERVICE
//https://api.themoviedb.org/3/discover/movie?api_key=###&year=2015&sort_by=popularity.desc

