package com.example.imdb_movies.model

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val service: MovieNetwork by lazy {
    val okHttpClient = OkHttpClient.Builder()
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    retrofit.create(MovieNetwork::class.java)
}

fun getNetworkService() = service


interface MovieNetwork {
    @GET("/3/movie/popular")
    fun fetchMovieList(apiKey : String): String
}


