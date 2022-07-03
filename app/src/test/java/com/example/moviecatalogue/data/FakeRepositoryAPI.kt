package com.example.moviecatalogue.data

import com.example.moviecatalogue.data.api.API
import com.example.moviecatalogue.data.model.DetaiTvShow
import com.example.moviecatalogue.data.model.DetailMovie
import com.example.moviecatalogue.data.model.Movie
import com.example.moviecatalogue.data.model.TvShow

class FakeRepositoryAPI(private val api: API) {
    suspend fun getUpComingMovies(): ArrayList<Movie>{
        val movie = api.getMovieUpcoming().resultsMovie
        return movie as ArrayList<Movie>
    }
    suspend fun getPopularTvshow(): ArrayList<TvShow>{
        val tvShow = api.getTvPopular().resultsTvShows
        return tvShow as ArrayList<TvShow>
    }
    suspend fun getMovieDetail(id:Int): DetailMovie {
        val movieDetail = api.getDetailMovie(id)
        return movieDetail
    }
    suspend fun getTvshowDetail(id: Int): DetaiTvShow {
        val tvDetail = api.getDetailTvShow(id)
        return tvDetail
    }
}