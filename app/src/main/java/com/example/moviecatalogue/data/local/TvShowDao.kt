package com.example.moviecatalogue.data.local

import androidx.paging.DataSource
import androidx.room.*
import com.example.moviecatalogue.data.model.Movie
import com.example.moviecatalogue.data.model.TvShow

@Dao
interface TvShowDao {
    @Query("Select * from tvshows")
    fun getFavoriteTv() : DataSource.Factory<Int, TvShow>

    @Query("Select count(*) from tvshows Where tvshows.id = :id")
    suspend fun isFavoriteTvShow(id: Int): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavoriteTvShow(tvShow: TvShow)

    @Delete
    suspend fun deleteFavoriteTvShow(tvShow: TvShow)
}