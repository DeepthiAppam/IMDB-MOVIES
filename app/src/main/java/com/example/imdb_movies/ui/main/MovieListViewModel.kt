package com.example.imdb_movies.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdb_movies.model.MovieRepository
import kotlinx.coroutines.launch
import java.lang.Exception


class MovieListViewModel : ViewModel() {
    private val repo = MovieRepository(getNetworkService())
    private val _movieList: MutableLiveData<List<String>> = MutableLiveData()
    val movieList = _movieList as LiveData<List<String>>

    init {
        getMoviesList()
    }

    private fun getMoviesList() = launchDataLoad {
        val result = repo.getPopularMovieList(MovieListRequestData())
        result
    }

    private fun launchDataLoad(block: suspend () -> Unit) {
        viewModelScope.launch {
            try {
                block()
            } catch (e: Exception) {
                Log.e("", "Unable to Fetch List", e)
            }
        }
    }
}