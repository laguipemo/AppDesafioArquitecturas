package com.laguipemo.appdesafioarquitecturas.domain.model

import com.laguipemo.appdesafioarquitecturas.frameworks.localdatabase.entities.LocalMovie

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 9/10/23 at 1:34
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val vote_average: Double,
    val backdrop_path: String,
    val poster_path: String,
    val isFavorite: Boolean = false
)

fun Movie.toLocalMovie() = LocalMovie(
    id = id,
    title = title,
    overview = overview,
    vote_average = vote_average,
    backdrop_path = backdrop_path,
    poster_path = poster_path,
    isFavorite = isFavorite
)
