package com.laguipemo.appdesafioarquitecturas.data.remote

import com.laguipemo.appdesafioarquitecturas.domain.model.Movie
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas.data.remote
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 9/10/23 at 2:46
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

class RemoteDataSource {
    suspend fun getMovies(): List<Movie> = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MoviesService::class.java)
        .getMovies()
        .results
        .map { it.toMovie() }
}