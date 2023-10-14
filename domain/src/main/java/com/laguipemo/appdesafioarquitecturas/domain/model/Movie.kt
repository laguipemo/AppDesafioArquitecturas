package com.laguipemo.appdesafioarquitecturas.domain.model


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
    val voteAverage: Double,
    val backdropPath: String,
    val posterPath: String,
    val isFavorite: Boolean = false
)
