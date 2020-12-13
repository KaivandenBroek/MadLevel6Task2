package com.example.madlevel6task2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.madlevel6task2.R
import com.example.madlevel6task2.model.Movie
import com.example.madlevel6task2.viewmodels.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class InfoFragment : Fragment() {

    private lateinit var movie: Movie
    private val viewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observer()
    }

    private fun observer() {
        viewModel.movie.observe(viewLifecycleOwner, { movieData ->
            movieData?.let {
                movie = movieData
                println("TEST fragment:$movie")
                updateMovieInformation()
            }
        })

    }

    // fill movie info
    private fun updateMovieInformation() {

        activity?.let {
            Glide.with(it).load(movie.getBannerImage()).into(ivBanner)
        }
        activity?.let {
            Glide.with(it).load(movie.getMovieImage()).into(ivMoviePhoto)
        }

        tvMovieTitle.text = movie.title
        tvMovieReleaseDate.text = movie.releaseDate
        tvMovieRating.text = movie.voteAverage.toString()
        tvOverview.text = movie.overview

        val ratingCalculation = (movie.voteAverage/10).toFloat()
        rbMovieRating.rating = ratingCalculation

    }
}