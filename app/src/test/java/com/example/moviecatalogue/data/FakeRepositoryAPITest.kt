package com.example.moviecatalogue.data

import com.example.moviecatalogue.data.api.API
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class FakeRepositoryAPITest {
    private lateinit var fakeRepositoryAPIAPI: FakeRepositoryAPI
    @Before
    fun setUp() {
        val retrofit = Retrofit.Builder()
            .baseUrl(API.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API::class.java)

        fakeRepositoryAPIAPI = FakeRepositoryAPI(retrofit)
    }
    @Test
    fun repositoryMovie() = runBlocking {
        val movie = fakeRepositoryAPIAPI.getUpComingMovies()
        Assert.assertNotNull(movie)
    }
    @Test
    fun repositoryMovieDetail() = runBlocking {
        val movie = fakeRepositoryAPIAPI.getMovieDetail(460465)
        Assert.assertNotNull(movie)
    }
    @Test
    fun repositoryTv() = runBlocking {
        val tv = fakeRepositoryAPIAPI.getPopularTvshow()
        Assert.assertNotNull(tv)
    }
    @Test
    fun repositoryTvDetail() = runBlocking {
        val tv = fakeRepositoryAPIAPI.getTvshowDetail(88396)
        Assert.assertNotNull(tv)
    }
}