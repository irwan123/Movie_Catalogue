package com.example.moviecatalogue.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetaiTvShow(
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("original_name")
    val originaltitle: String,
    @field:SerializedName("first_air_date")
    val firstairdate: String,
    @field:SerializedName("original_language")
    val originallanguage: String,
    @field:SerializedName("vote_average")
    val voteaverage: Double,
    @field:SerializedName("overview")
    val overview: String,
    @field:SerializedName("poster_path")
    val posterpath: String,
    @field:SerializedName("blackdrop_path")
    val blackdroppath: String,
    @field:SerializedName("popularity")
    val popularity: Double
) : Parcelable