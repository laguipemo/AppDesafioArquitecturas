package com.laguipemo.appdesafioarquitecturas.frameworks.remoteapi.model

import com.google.gson.annotations.SerializedName
import com.laguipemo.appdesafioarquitecturas.domain.model.Movie
import com.laguipemo.appdesafioarquitecturas.frameworks.localdatabase.entities.LocalMovie

data class ServerMovie(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int,
    val isFavorite: Boolean = false
)

fun ServerMovie.toLocalMovie() = LocalMovie(
    id = 0,
    title = title,
    overview = overview,
    voteAverage = voteAverage,
    backdropPath = backdropPath,
    posterPath = posterPath,
    isFavorite = isFavorite
)

fun ServerMovie.toMovie() = Movie(
    id = id,
    title = title,
    overview = overview,
    voteAverage = voteAverage,
    backdropPath = backdropPath,
    posterPath = posterPath,
    isFavorite = isFavorite
)