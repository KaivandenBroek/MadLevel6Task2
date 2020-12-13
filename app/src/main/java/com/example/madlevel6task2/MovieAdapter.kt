package com.example.madlevel6task2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.madlevel6task2.model.Movie
import com.example.madlevel6task2.model.MovieResponse
import kotlinx.android.synthetic.main.card_movie_item.view.*

class MovieAdapter(var arrayList: List<Movie>, private val onClick: (Movie) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.card_movie_item, parent, false)
        )
    }

    /**
     * Returns the amount of movies that are currently shown in the overview
     * @return [Int] Amount of movies
     */
    override fun getItemCount(): Int = arrayList.size

    /**
     * Initialise data binding.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(arrayList[position], position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /**
         * Fill movie item with data
         */
        fun databind(movie: Movie, position: Int) {
            val actualIndex = position+1
            itemView.tvMovieNumber.text = actualIndex.toString()
            Glide.with(context).load(movie.getMovieImage()).into(itemView.ivMovie)
        }

        /**
         * Setup on click listener to open detailed view for movie
         */
        init {
            itemView.setOnClickListener {
                onClick(arrayList[adapterPosition])
            }
        }
    }
}