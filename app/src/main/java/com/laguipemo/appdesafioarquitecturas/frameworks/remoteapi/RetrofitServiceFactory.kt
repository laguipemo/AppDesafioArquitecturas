package com.laguipemo.appdesafioarquitecturas.frameworks.remoteapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas.frameworks.remoteapi.apiservice
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 12/10/23 at 21:04
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

class RetrofitServiceFactory {

    companion object {
        @Volatile
        private var INSTANCE: RetrofitServiceFactory? = null

        fun getInstance(): RetrofitServiceFactory = INSTANCE ?: synchronized(this) {
            INSTANCE ?: RetrofitServiceFactory().also { INSTANCE = it }
        }
    }

    val retrofit: Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

