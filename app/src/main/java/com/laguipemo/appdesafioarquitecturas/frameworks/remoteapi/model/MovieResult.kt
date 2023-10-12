package com.laguipemo.appdesafioarquitecturas.frameworks.remoteapi.model

import com.google.gson.annotations.SerializedName

data class MovieResult(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<ServerMovie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)