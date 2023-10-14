package com.laguipemo.appdesafioarquitecturas.presentation.ui.screens.main

import com.laguipemo.appdesafioarquitecturas.domain.model.Movie

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 8/10/23 at 1:32
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

sealed interface MovieAction {
    class MovieFavoriteClick(val movie: com.laguipemo.appdesafioarquitecturas.domain.model.Movie) : MovieAction
    class MovieDeleteClick(val movie: com.laguipemo.appdesafioarquitecturas.domain.model.Movie) : MovieAction
    class MovieShareClick(val movie: com.laguipemo.appdesafioarquitecturas.domain.model.Movie) : MovieAction
}