package com.androiduitesting.data.source

import com.androiduitesting.data.Movie

interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?
}