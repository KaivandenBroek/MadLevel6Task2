package com.example.madlevel6task2

import com.google.gson.annotations.SerializedName

data class Movie (
    @SerializedName("original_title") var movieName: String,
    @SerializedName("id") var movieId: Int,
    @SerializedName("poster_path") var poster: String

) { // get picture by id nodig?
    fun getImageUrl() = "https://api.themoviedb.org/3/movie/$movieId?api_key=4e3a4dca7cbfff7bfd8ac3c401a0b5a3&language=en-US"
}
