package com.example.moviecatalogue.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviecatalogue.data.model.Movie
import com.example.moviecatalogue.data.model.TvShow

@Database(entities = [Movie::class, TvShow::class], version = 1)
abstract class DatabaseCatalogue : RoomDatabase(){
    abstract fun movieDa(): MovieDao
    abstract fun tvshowDao(): TvShowDao
}