package com.laguipemo.appdesafioarquitecturas.ui.screens.main

import com.laguipemo.appdesafioarquitecturas.data.remote.ServerMovie

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 8/10/23 at 1:32
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

sealed interface MovieAction {
    class MovieFavoriteClick(val movie: ServerMovie) : MovieAction
    class MovieDeleteClick(val movie: ServerMovie) : MovieAction
    class MovieShareClick(val movie: ServerMovie) : MovieAction
}