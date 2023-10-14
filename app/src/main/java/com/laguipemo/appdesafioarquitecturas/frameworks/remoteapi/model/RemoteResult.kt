package com.laguipemo.appdesafioarquitecturas.frameworks.remoteapi.model

import com.google.gson.annotations.SerializedName

data class RemoteResult(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val remoteMovies: List<RemoteMovie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)