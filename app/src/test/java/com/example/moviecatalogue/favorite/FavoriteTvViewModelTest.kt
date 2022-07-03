package com.example.moviecatalogue.favorite

import android.content.Context
import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.moviecatalogue.data.local.DatabaseCatalogue
import com.example.moviecatalogue.data.repository.RepositoryDatabase
import com.example.moviecatalogue.ui.favorite.fav_tvshow.FavTvViewModel
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class FavoriteTvViewModelTest {
    private lateinit var viewModel: FavTvViewModel
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
        viewModel = FavTvViewModel(repositoryDatabase)
    }
    @Test
    fun getFavoriteTv() = runBlocking {
        val tv = viewModel.getFavTv()
        Assert.assertNotNull(tv)
    }
}