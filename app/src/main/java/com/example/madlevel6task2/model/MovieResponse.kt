package com.example.madlevel6task2.model

import androidx.lifecycle.MutableLiveData
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    var results : ArrayList<Movie>
)
//) {
//    data class MResponse(val adult: Boolean, val backdrop_path: String, val genre_ids: List<Int>,
//                    val id: Int, val original_language: String, val original_title: String,
//                    val overview: String, val popularity: Double, val poster_path: String,
//                    val release_date: String, val title: String, val video: Boolean,
//                    val vote_average: Double, val vote_count: Int)
//}