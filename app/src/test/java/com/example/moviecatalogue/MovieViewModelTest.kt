package com.example.moviecatalogue

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.moviecatalogue.data.model.DetaiTvShow
import com.example.moviecatalogue.data.model.Movie
import com.example.moviecatalogue.data.model.TvShow
import com.example.moviecatalogue.data.repository.RepositoryAPI
import com.example.moviecatalogue.ui.movie.MovieViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest{
    private lateinit var movieModel : MovieViewModel
    // Rule
    @get:Rule
    var instantRule = InstantTaskExecutorRule()
    @get:Rule
    var coroutineRule = CoroutineRule()
    // Mock
    @Mock
    private lateinit var repositoryAPI: RepositoryAPI
    @Mock
    private lateinit var observer: Observer<List<Movie>>
    // Setup
    @Before
    fun setUp(){
        movieModel = MovieViewModel(repositoryAPI)
        movieModel.getMovies()
    }
    // Testing
    @Test
    fun getMovieList(){
        coroutineRule.runTest {
            movieModel.movieList.observeForever(observer)
            val movie = movieModel.movieList.value
            verify(repositoryAPI).getUpComingMovies()
            verify(observer).onChanged(movie)
        }
    }
}

