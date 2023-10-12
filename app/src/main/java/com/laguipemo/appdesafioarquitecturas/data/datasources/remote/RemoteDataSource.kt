package com.laguipemo.appdesafioarquitecturas.data.datasources.remote

import com.laguipemo.appdesafioarquitecturas.domain.model.Movie

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas.data.remote
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 9/10/23 at 2:46
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

interface RemoteDataSource {
    suspend fun getMovies(): List<Movie>
}