package com.laguipemo.appdesafioarquitecturas

import android.app.Application
import com.laguipemo.appdesafioarquitecturas.data.MoviesRepository
import com.laguipemo.appdesafioarquitecturas.data.datasources.local.LocalDataSource
import com.laguipemo.appdesafioarquitecturas.frameworks.localdatabase.MoviesDatabase
import com.laguipemo.appdesafioarquitecturas.data.datasources.remote.RemoteDataSource
import com.laguipemo.appdesafioarquitecturas.frameworks.datasourcesimpl.local.LocalDataSourceImpl
import com.laguipemo.appdesafioarquitecturas.frameworks.datasourcesimpl.remote.RemoteDataSourceImpl

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
            LocalDataSourceImpl(database.moviesDao()),
            RemoteDataSourceImpl()
        )
    }
}