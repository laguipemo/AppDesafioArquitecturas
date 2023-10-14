package com.laguipemo.appdesafioarquitecturas.usecases

import com.laguipemo.appdesafioarquitecturas.data.MoviesRepository
import com.laguipemo.appdesafioarquitecturas.domain.model.Movie

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas.usecases
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 15/10/23 at 0:53
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

class UpdateMovieUseCase(private val repository: MoviesRepository) {

    suspend operator fun invoke(movie: Movie)  = repository.updateMovie(movie)

}