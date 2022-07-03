package com.example.moviecatalogue.data.repository

import com.example.moviecatalogue.data.local.DatabaseCatalogue
import com.example.moviecatalogue.data.local.MovieDao
import com.example.moviecatalogue.data.local.TvShowDao
import com.example.moviecatalogue.data.model.Movie
import com.example.moviecatalogue.data.model.TvShow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryDatabase @Inject constructor(
    database: DatabaseCatalogue
){
    private val movieDao: MovieDao = database.movieDa()
    private val tvShowDao: TvShowDao = database.tvshowDao()

    fun getFavoriteMovie() = movieDao.getFavoriteMovie()

    suspend fun addFavoriteMovie(movie: Movie) = movieDao.addFavoriteMovie(movie)
    suspend fun deleteFavoriteMovie(movie: Movie) = movieDao.deleteFavoriteMovie(movie)
    suspend fun isFavoriteMovie(movie: Movie) = movieDao.isFavoriteMovie(movie.id)

    fun getFavoriteTvShow() = tvShowDao.getFavoriteTv()

    suspend fun addFavoriteTv(tvShow: TvShow) = tvShowDao.addFavoriteTvShow(tvShow)
    suspend fun deleteFavoriteTv(tvShow: TvShow) = tvShowDao.deleteFavoriteTvShow(tvShow)
    suspend fun isFavoriteTv(tvShow: TvShow) = tvShowDao.isFavoriteTvShow(tvShow.id)
}
