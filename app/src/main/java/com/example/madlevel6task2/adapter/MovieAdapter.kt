package com.example.madlevel6task2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.madlevel6task2.R
import com.example.madlevel6task2.model.Movie
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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(arrayList[position], position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(movie: Movie, position: Int) {
            val actualIndex = position+1
            itemView.tvMovieNumber.text = actualIndex.toString()
            Glide.with(context).load(movie.getMovieImage()).into(itemView.ivMovie)
        }

        // give movie to bannerclick
        init {
            itemView.setOnClickListener {
                onClick(arrayList[adapterPosition])
            }
        }
    }
}