package com.laguipemo.appdesafioarquitecturas.usecases

import com.laguipemo.appdesafioarquitecturas.data.MoviesRepository

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas.usecases
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 15/10/23 at 0:15
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

class RequestMovieUseCase (private val repository: MoviesRepository) {

    suspend operator fun invoke()  = repository.requestMovies()

}