package com.example.imdb_movies.model

import android.util.Log
import com.example.imdb_movies.ui.main.MovieListRequestData
import com.example.imdb_movies.ui.main.MovieNetwork

class MovieRepository(private val network : MovieNetwork) {
    suspend fun getPopularMovieList(movieListRequestData: MovieListRequestData) : List<String> {
        var result = listOf<String>()
        try {
            result = listOf(network.fetchMovieList(apiKey = movieListRequestData.apiKey))
        } catch (error: Throwable) {
            Log.e(TAG,"Unable to fetch Movie List : ${error.message}",error)
            throw error
        }
        return result
    }
    companion object{
        val TAG: String = MovieRepository::javaClass.name
    }
}