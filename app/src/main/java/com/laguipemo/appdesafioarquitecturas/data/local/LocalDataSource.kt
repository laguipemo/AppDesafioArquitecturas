package com.laguipemo.appdesafioarquitecturas.data.local

import com.laguipemo.appdesafioarquitecturas.Movie
import com.laguipemo.appdesafioarquitecturas.toLocalMovie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas.data.local
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 9/10/23 at 2:46
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

class LocalDataSource(private val dao: MoviesDao) {

    val movies: Flow<List<Movie>> = dao.getMovies().map {localMovies ->
        localMovies.map { it.toMovie() }
    }

    suspend fun insertMovie(movie: Movie) {
        dao.insertMovie(movie.toLocalMovie())
    }

    suspend fun insertMovies(movies: List<Movie>) {
        dao.insertMovies(movies.map { it.toLocalMovie() })
    }

    suspend fun updateMovie(movie: Movie) {
        dao.updateMovie(movie.toLocalMovie())
    }

    suspend fun getCount(): Int {
        return dao.getCount()
    }

}