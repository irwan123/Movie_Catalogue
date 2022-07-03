package com.example.moviecatalogue.data.api

import com.example.moviecatalogue.data.model.DetailMovie
import com.example.moviecatalogue.data.model.DetaiTvShow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API {
    companion object {
        const val URL_BASE = ("https://api.themoviedb.org/3/")
        const val API_KEY = "ff5419e5a2232b1058c42eff50b9ea7b"
    }

    @GET("movie/upcoming")
    suspend fun getMovieUpcoming(
        @Query("api_key") apiKey:String = API_KEY,
        @Query("language") language: String = "en-Us",
        @Query("api_key") page: String = "1",
    ) : ResponseMovie
    @GET("movie/{id}")
    suspend fun getDetailMovie(
        @Path("id") id:Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en-Us"
    ) : DetailMovie
    @GET("tv/popular")
    suspend fun getTvPopular(
        @Query("api_key") apiKey:String = API_KEY,
        @Query("language") language: String = "en-Us",
        @Query("api_key") page: String = "1",
    ) : ResponseTvShows
    @GET("tv/{id}")
    suspend fun getDetailTvShow(
        @Path("id") id:Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en-Us"
    ) : DetaiTvShow
}