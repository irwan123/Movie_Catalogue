package com.example.moviecatalogue.favorite

import android.app.Application
import android.content.Context
import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.moviecatalogue.data.local.DatabaseCatalogue
import com.example.moviecatalogue.data.local.MovieDao
import com.example.moviecatalogue.data.repository.RepositoryDatabase
import com.example.moviecatalogue.ui.favorite.fav_movie.FavMovieViewModel
import com.example.moviecatalogue.ui.favorite.fav_tvshow.FavTvViewModel
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.io.IOException
import kotlin.jvm.Throws

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class FavoriteMovieViewModelTest {
    private lateinit var viewModel: FavMovieViewModel
    private lateinit var repositoryDatabase: RepositoryDatabase
    private lateinit var databaseCatalogue: DatabaseCatalogue

   @get:Rule
   var instantRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        val context  = ApplicationProvider.getApplicationContext<Context>()
        databaseCatalogue = Room.inMemoryDatabaseBuilder(
            context, DatabaseCatalogue::class.java
        ).build()
        repositoryDatabase = RepositoryDatabase(databaseCatalogue)
        viewModel = FavMovieViewModel(repositoryDatabase)
        viewModel.getFavMovie()
    }
    @Test
    @Throws (IOException::class)
    fun getFavoriteMovie() = runBlocking {
        val movie = viewModel.getFavMovie()
        Assert.assertNotNull(movie)
    }
}