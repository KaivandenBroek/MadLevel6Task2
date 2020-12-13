package com.example.madlevel6task2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.madlevel6task2.MovieAdapter
import com.example.madlevel6task2.viewmodels.MovieViewModel
import com.example.madlevel6task2.R
import com.example.madlevel6task2.model.Movie
import com.example.madlevel6task2.viewmodels.MovieInfoViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {
    private var movies = arrayListOf<Movie>()
    private lateinit var movieAdapter: MovieAdapter
    private val viewModel: MovieViewModel by activityViewModels()
    private val viewModelMInfo: MovieInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSearch.setOnClickListener {
            viewModelMInfo.getMoviesByYear(tfYear.text.toString())
        }
        initViews()
    }

    private fun initViews() {
        movieAdapter = MovieAdapter(movies, ::toMovie)
        rvMovies.layoutManager = GridLayoutManager(context, 2)
        rvMovies.adapter = movieAdapter
        observeMovies()
    }

    private fun observeMovies() {
        viewModelMInfo.movieData.observe(viewLifecycleOwner, { response ->
            movies.clear()
            movies.addAll(response.results)
            movieAdapter.notifyDataSetChanged()
        })
        // Observe the error message.
        viewModel.errorText.observe(viewLifecycleOwner, {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })
    }

    private fun toMovie(movie: Movie) {
        viewModel.setMovie(movie)
        findNavController().navigate(R.id.action_listFragment_to_infoFragment2)
    }

}