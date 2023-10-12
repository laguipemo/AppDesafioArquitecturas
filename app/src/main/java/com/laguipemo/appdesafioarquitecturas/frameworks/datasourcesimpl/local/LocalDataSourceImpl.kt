package com.laguipemo.appdesafioarquitecturas.frameworks.datasourcesimpl.local

import com.laguipemo.appdesafioarquitecturas.data.datasources.local.LocalDataSource
import com.laguipemo.appdesafioarquitecturas.domain.model.Movie
import com.laguipemo.appdesafioarquitecturas.domain.model.toLocalMovie
import com.laguipemo.appdesafioarquitecturas.frameworks.localdatabase.daos.MoviesDao
import com.laguipemo.appdesafioarquitecturas.frameworks.localdatabase.entities.toMovie
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

class LocalDataSourceImpl(private val dao: MoviesDao) : LocalDataSource {

    override val movies: Flow<List<Movie>>
        get() = dao.getMovies().map { localMovies -> localMovies.map { it.toMovie() }}

    override suspend fun insertMovie(movie: Movie) {
        dao.insertMovie(movie.toLocalMovie())
    }

    override suspend fun insertMovies(movies: List<Movie>) {
        dao.insertMovies(movies.map { it.toLocalMovie() })
    }

    override suspend fun updateMovie(movie: Movie) {
        dao.updateMovie(movie.toLocalMovie())
    }

    override suspend fun getCount(): Int {
        return dao.getCount()
    }

}