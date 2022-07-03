package com.example.moviecatalogue.data

import android.content.Context
import androidx.paging.PagedList
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.moviecatalogue.data.local.DatabaseCatalogue
import com.example.moviecatalogue.data.model.Movie
import com.example.moviecatalogue.data.model.TvShow
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class FakeRepositoryDatabaseTest {
    private lateinit var databaseCatalogue: DatabaseCatalogue
    private lateinit var fakeRepositoryDatabase: FakeRepositoryDatabase
    private lateinit var context: Context
    val sampleDataMovie = Movie(
        1,
        "Title_Movie",
        "Language_Movie",
        "6-07-2021",
        8.2,
        "Overview_Movie",
        "PosterPath_Movie"
    )
    val sampleDataTv = TvShow(
        1,
        "Title_Tv",
        "6-07-2021",
        "Language_Tv",
        8.2,
        "Overview_Tv",
        "PosterPath_Tv"
    )
    val responMovie = listOf(sampleDataMovie)
    val responTv = listOf(sampleDataTv)

    @Before
    fun setUp(){
        context = ApplicationProvider.getApplicationContext()
        databaseCatalogue = Room.inMemoryDatabaseBuilder(
            context, DatabaseCatalogue::class.java
        ).build()
        fakeRepositoryDatabase = FakeRepositoryDatabase(databaseCatalogue)
    }
    @After
    fun close(){
        databaseCatalogue.close()
    }
    // Test Get Favorite
    @Test
    fun getFavMovie() = runBlocking {
        fakeRepositoryDatabase.addFavoriteMovie(sampleDataMovie)
        fakeRepositoryDatabase.getFavMovie()
        val entityMovie = pagedList(listOf(sampleDataMovie))
        Assert.assertNotNull(entityMovie)
        Assert.assertEquals(responMovie.size, entityMovie.size)
    }
    @Test
    fun getFavTv() = runBlocking {
        fakeRepositoryDatabase.addFavoriteTv(sampleDataTv)
        fakeRepositoryDatabase.getFavTvShow()
        val entityTv = pagedList(listOf(sampleDataTv))
        Assert.assertNotNull(entityTv)
        Assert.assertEquals(responTv.size, entityTv.size)
    }
    // Test Add Favorite
    @Test
    fun addFavMovie() = runBlocking {
        fakeRepositoryDatabase.addFavoriteMovie(sampleDataMovie)
        val hasilCheck = fakeRepositoryDatabase.isFavoriteMovie(sampleDataMovie)
        Assert.assertEquals(1, hasilCheck)
    }
    @Test
    fun addFavTv() = runBlocking {
        fakeRepositoryDatabase.addFavoriteTv(sampleDataTv)
        val hasilCheck = fakeRepositoryDatabase.isFavoriteTv(sampleDataTv)
        Assert.assertEquals(1, hasilCheck)
    }
    // Test Delete Favorite
    @Test
    fun deleteMovie() = runBlocking {
        fakeRepositoryDatabase.addFavoriteMovie(sampleDataMovie)
        fakeRepositoryDatabase.deleteFavoriteMovie(sampleDataMovie)
        val hasilCheck = fakeRepositoryDatabase.isFavoriteMovie(sampleDataMovie)
        Assert.assertEquals(0, hasilCheck)
    }
    @Test
    fun deleteTv() = runBlocking {
        fakeRepositoryDatabase.addFavoriteTv(sampleDataTv)
        fakeRepositoryDatabase.deleteFavoriteTv(sampleDataTv)
        val hasilCheck = fakeRepositoryDatabase.isFavoriteTv(sampleDataTv)
        Assert.assertEquals(0, hasilCheck)
    }

    private fun <T> pagedList(list: List<T>): PagedList<T> {
        val pagedList = Mockito.mock(PagedList::class.java) as PagedList<T>
        Mockito.`when`(pagedList[ArgumentMatchers.anyInt()]).then { invocation ->
            val index = invocation.arguments.first() as Int
            list[index]
        }
        Mockito.`when`(pagedList.size).thenReturn(list.size)
        return pagedList
    }
}