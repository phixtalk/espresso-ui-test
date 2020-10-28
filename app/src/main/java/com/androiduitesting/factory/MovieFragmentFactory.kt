package com.androiduitesting.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.androiduitesting.movie.DirectorsFragment
import com.androiduitesting.movie.MovieDetailFragment
import com.androiduitesting.movie.StarActorsFragment

class MovieFragmentFactory : FragmentFactory() {

    private val TAG: String = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment =

        when (className) {
            MovieDetailFragment::class.java.name -> {
                MovieDetailFragment()
            }

            DirectorsFragment::class.java.name -> {
                DirectorsFragment()
            }

            StarActorsFragment::class.java.name -> {
                StarActorsFragment()
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }

}