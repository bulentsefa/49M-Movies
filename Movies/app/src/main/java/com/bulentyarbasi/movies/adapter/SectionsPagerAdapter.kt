package com.bulentyarbasi.movies.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bulentyarbasi.movies.view.NowPlayingsFragment
import com.bulentyarbasi.movies.R
import com.bulentyarbasi.movies.view.TopRatedFragment
import com.bulentyarbasi.movies.view.UpcomingsFragment

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> NowPlayingsFragment()
            1 -> TopRatedFragment()
            2 -> UpcomingsFragment()
            else -> NowPlayingsFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Now Playings"
            1 -> "Top Rated"
            2 -> "Upcomings"
            else -> "Now Playings"
        }
    }

    override fun getCount(): Int {
        return 3
    }
}