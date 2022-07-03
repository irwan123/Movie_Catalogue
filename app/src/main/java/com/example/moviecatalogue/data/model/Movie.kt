package com.example.moviecatalogue.data.model
import android.os.Parcelable
import  android.os.Parcel
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
@Entity(tableName = "movie")
@Parcelize
data class Movie(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    @field:SerializedName("id")
    val id: Int,

    @ColumnInfo(name = "original_title")
    @field:SerializedName("original_title")
    val originaltitle: String,

    @ColumnInfo(name = "original_language")
    @field:SerializedName("original_language")
    val originallanguage: String,

    @ColumnInfo(name = "release_date")
    @field:SerializedName("release_date")
    val releasedate: String,

    @ColumnInfo(name = "vote_average")
    @field:SerializedName("vote_average")
    val voteaverage: Double,

    @ColumnInfo(name = "overview")
    @field:SerializedName("overview")
    val overview: String,

    @ColumnInfo(name = "poster_path")
    @field:SerializedName("poster_path")
    val posterpath: String
) : Parcelable
