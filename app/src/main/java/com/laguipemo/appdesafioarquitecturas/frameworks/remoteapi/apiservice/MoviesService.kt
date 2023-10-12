package com.laguipemo.appdesafioarquitecturas.frameworks.remoteapi.apiservice

import com.laguipemo.appdesafioarquitecturas.frameworks.remoteapi.model.MovieResult
import retrofit2.http.GET

/**
 * Project: DesafioArquitecturas
 * from: com.laguipemo.desafioarquitecturas
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 2/10/23 at 23:57
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

interface MoviesService {

    @GET("discover/movie?api_key=69c4fb98d771991f2cbf2edbe3b2ea88")
    suspend fun getMovies(): MovieResult
}