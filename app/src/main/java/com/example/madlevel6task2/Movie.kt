package com.example.madlevel6task2

data class Movie (
        var movieName: String,
        var movieId: Int

) { // get picture by id
    fun getImageUrl() = "https://api.themoviedb.org/3/discover/movie/$movieId?api_key=4e3a4dca7cbfff7bfd8ac3c401a0b5a3&language=en-US"
    // TODO add /poster_path  ?
}
