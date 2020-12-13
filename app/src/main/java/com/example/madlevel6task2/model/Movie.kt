package com.example.madlevel6task2.model

import com.google.gson.annotations.SerializedName

data class Movie (

    @SerializedName("title")            val title : String,
    @SerializedName("original_title")   val originalTitle : String,
    @SerializedName("poster_path")      val posterPath : String,
    @SerializedName("id")               val id : Int,
    @SerializedName("backdrop_path")    val backdropPath : String,
    @SerializedName("original_language")val originalLanguage : String,
    @SerializedName("vote_average")     val voteAverage : Double,
    @SerializedName("overview")         val overview : String,
    @SerializedName("release_date")     val releaseDate : String

) {

    fun getMovieImage() = "https://image.tmdb.org/t/p/w500/$posterPath"
    fun getBannerImage() = "https://image.tmdb.org/t/p/w500/$backdropPath"
}
