package com.laguipemo.appdesafioarquitecturas.frameworks.datasourcesimpl.remote

import com.laguipemo.appdesafioarquitecturas.data.datasources.remote.RemoteDataSource
import com.laguipemo.appdesafioarquitecturas.domain.model.Movie
import com.laguipemo.appdesafioarquitecturas.frameworks.remoteapi.apiservice.MoviesService
import com.laguipemo.appdesafioarquitecturas.frameworks.remoteapi.model.toMovie

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas.data.remote
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 9/10/23 at 2:46
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

class RemoteDataSourceImpl(private val moviesService: MoviesService) : RemoteDataSource {

    override suspend fun getMovies(): List<Movie> =
        moviesService.getMovies().remoteMovies.map { it.toMovie() }

}