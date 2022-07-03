package com.example.moviecatalogue.data.local

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.*
import com.example.moviecatalogue.data.model.Movie

@Dao
interface MovieDao {

    @Query("Select * from movie")
    fun getFavoriteMovie() : DataSource.Factory<Int, Movie>

    @Query("Select count(*) from movie Where movie.id = :id")
    suspend fun isFavoriteMovie(id: Int): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavoriteMovie(movie: Movie)

    @Delete
    suspend fun deleteFavoriteMovie(movie: Movie)
}