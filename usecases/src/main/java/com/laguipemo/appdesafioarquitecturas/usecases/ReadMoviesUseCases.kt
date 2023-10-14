package com.laguipemo.appdesafioarquitecturas.usecases

import com.laguipemo.appdesafioarquitecturas.data.MoviesRepository
import com.laguipemo.appdesafioarquitecturas.domain.model.Movie
import kotlinx.coroutines.flow.Flow

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas.usecases
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 15/10/23 at 0:25
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

class ReadMoviesUseCases(private val repository: MoviesRepository) {

    operator fun invoke() : Flow<List<Movie>> = repository.movies
}