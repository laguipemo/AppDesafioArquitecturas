package com.laguipemo.appdesafioarquitecturas.data.datasources.local

import com.laguipemo.appdesafioarquitecturas.domain.model.Movie
import kotlinx.coroutines.flow.Flow

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas.data.local
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 9/10/23 at 2:46
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

interface LocalDataSource {

    val movies: Flow<List<Movie>>

    suspend fun insertMovie(movie: Movie)

    suspend fun insertMovies(movies: List<Movie>)

    suspend fun updateMovie(movie: Movie)

    suspend fun getCount(): Int

}