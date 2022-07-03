package com.example.moviecatalogue.data

import com.example.moviecatalogue.data.local.DatabaseCatalogue
import com.example.moviecatalogue.data.local.MovieDao
import com.example.moviecatalogue.data.local.TvShowDao
import com.example.moviecatalogue.data.model.Movie
import com.example.moviecatalogue.data.model.TvShow

class FakeRepositoryDatabase (databaseCatalogue: DatabaseCatalogue) {
    private val movieDao: MovieDao = databaseCatalogue.movieDa()
    private val tvDao: TvShowDao = databaseCatalogue.tvshowDao()

    fun getFavMovie() = movieDao.getFavoriteMovie()

    suspend fun addFavoriteMovie(movie: Movie) = movieDao.addFavoriteMovie(movie)
    suspend fun deleteFavoriteMovie(movie: Movie) = movieDao.deleteFavoriteMovie(movie)
    suspend fun isFavoriteMovie(movie: Movie) = movieDao.isFavoriteMovie(movie.id)

    fun getFavTvShow() = tvDao.getFavoriteTv()

    suspend fun addFavoriteTv(tvShow: TvShow) = tvDao.addFavoriteTvShow(tvShow)
    suspend fun deleteFavoriteTv(tvShow: TvShow) = tvDao.deleteFavoriteTvShow(tvShow)
    suspend fun isFavoriteTv(tvShow: TvShow) = tvDao.isFavoriteTvShow(tvShow.id)
}