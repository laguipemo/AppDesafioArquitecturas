package com.laguipemo.appdesafioarquitecturas

import android.app.Application
import com.laguipemo.appdesafioarquitecturas.data.MoviesRepository
import com.laguipemo.appdesafioarquitecturas.data.local.LocalDataSource
import com.laguipemo.appdesafioarquitecturas.data.local.MoviesDatabase
import com.laguipemo.appdesafioarquitecturas.data.remote.RemoteDataSource

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 9/10/23 at 1:05
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

class MoviesApplication : Application(){

    val database : MoviesDatabase by lazy { MoviesDatabase.getDatabase(this) }
    val repository: MoviesRepository by lazy {
        MoviesRepository(
            LocalDataSource(database.moviesDao()),
            RemoteDataSource()
        )
    }
}