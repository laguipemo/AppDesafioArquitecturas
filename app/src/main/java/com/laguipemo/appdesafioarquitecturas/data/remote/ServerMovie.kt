package com.laguipemo.appdesafioarquitecturas.data.remote

import com.laguipemo.appdesafioarquitecturas.domain.model.Movie
import com.laguipemo.appdesafioarquitecturas.data.local.LocalMovie

data class ServerMovie(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int,
    val isFavorite: Boolean = false
)

fun ServerMovie.toLocalMovie() = LocalMovie(
    id = 0,
    title = title,
    overview = overview,
    vote_average = vote_average,
    backdrop_path = backdrop_path,
    poster_path = poster_path,
    isFavorite = isFavorite
)

fun ServerMovie.toMovie() = Movie(
    id = id,
    title = title,
    overview = overview,
    vote_average = vote_average,
    backdrop_path = backdrop_path,
    poster_path = poster_path,
    isFavorite = isFavorite
)