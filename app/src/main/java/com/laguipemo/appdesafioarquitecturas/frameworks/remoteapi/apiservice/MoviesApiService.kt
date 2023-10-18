package com.laguipemo.appdesafioarquitecturas.frameworks.remoteapi.apiservice

import com.laguipemo.appdesafioarquitecturas.domain.common.Constants
import com.laguipemo.appdesafioarquitecturas.frameworks.remoteapi.model.RemoteResult
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Project: DesafioArquitecturas
 * from: com.laguipemo.desafioarquitecturas
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 2/10/23 at 23:57
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

interface MoviesApiService {

    @GET(Constants.STATIC_API_URL)
    suspend fun getMovies(
        @Query("api_key") apiKey: String = Constants.APY_KEY,
        @Query("region") region: String = Constants.REGION,
    ): RemoteResult
}