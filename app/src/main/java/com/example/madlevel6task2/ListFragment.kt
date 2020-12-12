package com.example.madlevel6task2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {
    private lateinit var movies: ArrayList<Movie>
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var viewManager: GridLayoutManager

    private val viewModel: MovieViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSearch.setOnClickListener {
            viewModel.getMovieList(tfYear.text.toString())
        }
        initViews()
    }

    private fun initViews() {
        movies = arrayListOf()
        movieAdapter = MovieAdapter(movies, requireContext())
        //viewManager = GridLayoutManager(activity, 2) // nodig?
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