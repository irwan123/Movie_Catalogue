package com.example.moviecatalogue.data.api

import com.example.moviecatalogue.data.model.TvShow
import com.google.gson.annotations.SerializedName

data class ResponseTvShows (
    @field:SerializedName("results")
    val resultsTvShows:ArrayList<TvShow>
)