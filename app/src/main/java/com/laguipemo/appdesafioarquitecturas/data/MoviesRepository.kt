package com.laguipemo.appdesafioarquitecturas.data

import com.laguipemo.appdesafioarquitecturas.domain.model.Movie
import com.laguipemo.appdesafioarquitecturas.data.local.LocalDataSource
import com.laguipemo.appdesafioarquitecturas.data.remote.RemoteDataSource
import kotlinx.coroutines.flow.Flow

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas.data
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 9/10/23 at 3:03
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

class MoviesRepository (
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {
    val movies: Flow<List<Movie>> = localDataSource.movies

    suspend fun updateMovie(movie: Movie) {
        localDataSource.updateMovie(movie)
    }

    suspend fun requestMovies() {
        if (localDataSource.getCount() == 0) {
            localDataSource.insertMovies(remoteDataSource.getMovies())
        }
    }
}