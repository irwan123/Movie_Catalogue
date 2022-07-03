package com.example.moviecatalogue.data.api
import android.os.Parcelable
import com.example.moviecatalogue.data.model.Movie
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class ResponseMovie (
    @field:SerializedName("results")
    val resultsMovie:ArrayList<Movie>
)