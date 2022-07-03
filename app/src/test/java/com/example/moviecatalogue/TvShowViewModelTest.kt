package com.example.moviecatalogue

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.moviecatalogue.data.model.Movie
import com.example.moviecatalogue.data.model.TvShow
import com.example.moviecatalogue.data.repository.RepositoryAPI
import com.example.moviecatalogue.ui.movie.MovieViewModel
import com.example.moviecatalogue.ui.tvshow.TvShowViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest{
    private lateinit var tvModel : TvShowViewModel
    // Rule
    @get:Rule
    var instantRule = InstantTaskExecutorRule()
    @get:Rule
    var coroutineRule = CoroutineRule()
    // Mock
    @Mock
    private lateinit var repositoryAPI: RepositoryAPI
    @Mock
    private lateinit var observer: Observer<List<TvShow>>
    // SetUp
    @Before
    fun setUp(){
        tvModel = TvShowViewModel(repositoryAPI)
        tvModel.getTv()
    }
    // Testing
    @Test
    fun getTvList(){
        coroutineRule.runTest {
            tvModel.tvList.observeForever(observer)
            val tvShow = tvModel.tvList.value
            Mockito.verify(repositoryAPI).getPopularTvshow()
            Mockito.verify(observer).onChanged(tvShow)
        }
    }
}