package com.laguipemo.appdesafioarquitecturas

import android.app.Application
import com.laguipemo.appdesafioarquitecturas.data.MoviesRepository
import com.laguipemo.appdesafioarquitecturas.frameworks.localdatabase.MoviesDatabase
import com.laguipemo.appdesafioarquitecturas.frameworks.datasourcesimpl.local.LocalDataSourceImpl
import com.laguipemo.appdesafioarquitecturas.frameworks.datasourcesimpl.remote.RemoteDataSourceImpl
import com.laguipemo.appdesafioarquitecturas.frameworks.remoteapi.RetrofitServiceFactory
import com.laguipemo.appdesafioarquitecturas.frameworks.remoteapi.apiservice.MoviesService
import com.laguipemo.appdesafioarquitecturas.usecases.ReadMoviesUseCases
import com.laguipemo.appdesafioarquitecturas.usecases.RequestMovieUseCase
import com.laguipemo.appdesafioarquitecturas.usecases.UpdateMovieUseCase
import retrofit2.Retrofit

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 9/10/23 at 1:05
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

class MoviesApplication : Application(){

    private val database : MoviesDatabase by lazy { MoviesDatabase.getDatabase(this) }
    private val retrofit: Retrofit by lazy { RetrofitServiceFactory.getInstance().retrofit }
    val repository: MoviesRepository by lazy {
        MoviesRepository(
            LocalDataSourceImpl(database.moviesDao()),
            RemoteDataSourceImpl(retrofit.create(MoviesService::class.java))
        )
    }
    val requestMovieUseCase: RequestMovieUseCase by lazy {  RequestMovieUseCase(repository)}
    val readMoviesUseCases: ReadMoviesUseCases by lazy { ReadMoviesUseCases(repository) }
    val updateMovieUseCase: UpdateMovieUseCase by lazy { UpdateMovieUseCase(repository) }
}