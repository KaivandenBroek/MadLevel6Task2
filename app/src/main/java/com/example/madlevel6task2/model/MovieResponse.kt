package com.example.madlevel6task2.model

import androidx.lifecycle.MutableLiveData
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    var results : ArrayList<Movie>
)