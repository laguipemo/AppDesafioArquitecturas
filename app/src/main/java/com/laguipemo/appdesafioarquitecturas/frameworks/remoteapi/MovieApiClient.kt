package com.laguipemo.appdesafioarquitecturas.frameworks.remoteapi

import com.laguipemo.appdesafioarquitecturas.domain.common.Constants
import com.laguipemo.appdesafioarquitecturas.frameworks.remoteapi.apiservice.MoviesApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas.frameworks.remoteapi
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 18/10/23 at 21:09
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

object MovieApiClient {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .build()

    val service: MoviesApiService by lazy { retrofit.create(MoviesApiService::class.java) }
}