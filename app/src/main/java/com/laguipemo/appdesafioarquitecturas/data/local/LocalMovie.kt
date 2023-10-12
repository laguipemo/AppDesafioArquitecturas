package com.laguipemo.appdesafioarquitecturas.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.laguipemo.appdesafioarquitecturas.domain.model.Movie

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas.data.local
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 8/10/23 at 22:38
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

@Entity(tableName = "LocalMovie")
data class LocalMovie(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val overview: String,
    val vote_average: Double,
    val backdrop_path: String,
    val poster_path: String,
    val isFavorite: Boolean = false
)

fun LocalMovie.toMovie() = Movie(
    id = id,
    title = title,
    overview = overview,
    vote_average = vote_average,
    backdrop_path = backdrop_path,
    poster_path = poster_path,
    isFavorite = isFavorite
)

