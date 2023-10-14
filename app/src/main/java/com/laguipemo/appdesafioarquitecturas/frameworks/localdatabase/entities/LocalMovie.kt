package com.laguipemo.appdesafioarquitecturas.frameworks.localdatabase.entities

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
    val voteAverage: Double,
    val backdropPath: String,
    val posterPath: String,
    val isFavorite: Boolean = false
)

//Mappers
fun LocalMovie.toMovie() = Movie(
    id = id,
    title = title,
    overview = overview,
    voteAverage = voteAverage,
    backdropPath = backdropPath,
    posterPath = posterPath,
    isFavorite = isFavorite
)

