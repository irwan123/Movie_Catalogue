package com.example.moviecatalogue.data.repository

import com.example.moviecatalogue.data.EspressoIdlingResource
import com.example.moviecatalogue.data.api.API
import com.example.moviecatalogue.data.model.Movie
import com.example.moviecatalogue.data.model.DetailMovie
import com.example.moviecatalogue.data.model.TvShow
import com.example.moviecatalogue.data.model.DetaiTvShow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryAPI @Inject constructor(private val api: API) {
    suspend fun getUpComingMovies(): ArrayList<Movie>{
        EspressoIdlingResource.increment()
        val movie = api.getMovieUpcoming().resultsMovie
        EspressoIdlingResource.decrement()
        return movie as ArrayList<Movie>
    }
    suspend fun getPopularTvshow(): ArrayList<TvShow>{
        EspressoIdlingResource.increment()
        val tvShow = api.getTvPopular().resultsTvShows
        EspressoIdlingResource.decrement()
        return tvShow as ArrayList<TvShow>
    }
    suspend fun getMovieDetail(id:Int): DetailMovie{
        EspressoIdlingResource.increment()
        val movieDetail = api.getDetailMovie(id)
        EspressoIdlingResource.decrement()
        return movieDetail
    }
    suspend fun getTvshowDetail(id: Int): DetaiTvShow{
        EspressoIdlingResource.increment()
        val tvDetail = api.getDetailTvShow(id)
        EspressoIdlingResource.decrement()
        return tvDetail
    }
}