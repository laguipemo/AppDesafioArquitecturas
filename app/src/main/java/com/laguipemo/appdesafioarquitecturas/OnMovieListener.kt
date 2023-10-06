package com.laguipemo.appdesafioarquitecturas

import java.text.FieldPosition

/**
 * Project: DesafioArquitecturas
 * from: com.laguipemo.desafioarquitecturas
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 3/10/23 at 22:10
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

interface OnMovieListener {
    fun onMovieClick(movie: ServerMovie, position: Int)
    fun onFavoriteClick(movie: ServerMovie, position: Int)
}