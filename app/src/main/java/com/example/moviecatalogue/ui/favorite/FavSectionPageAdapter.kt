package com.example.moviecatalogue.ui.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.moviecatalogue.R
import com.example.moviecatalogue.ui.favorite.fav_movie.FavMovieFragment
import com.example.moviecatalogue.ui.favorite.fav_tvshow.FavTvFragment
import com.example.moviecatalogue.ui.movie.MovieFragment
import com.example.moviecatalogue.ui.tvshow.TvFragment

class FavSectionPageAdapter(private val mContext: Context, fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab1,
            R.string.tab2
        )
    }
    override fun getItem(position: Int): Fragment =
        when(position){
            0 -> FavMovieFragment()
            1 -> FavTvFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(
        TAB_TITLES[position])
    override fun getCount(): Int = 2
}