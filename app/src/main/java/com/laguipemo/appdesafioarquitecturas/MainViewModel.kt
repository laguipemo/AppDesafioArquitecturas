package com.laguipemo.appdesafioarquitecturas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 4/10/23 at 22:08
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

class MainViewModel : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }
            delay(2000)
            _state.update {
                it.copy(
                    movies = Retrofit.Builder()
                        .baseUrl("https://api.themoviedb.org/3/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(MoviesService::class.java)
                        .getMovies()
                        .results
                )
            }
            _state.update {
                it.copy(
                    isLoading = false
                )
            }
        }
    }

    fun updateFavorite(movie: ServerMovie) {
        movie.isFavorite = !movie.isFavorite
//        viewModelScope.launch {
//            _state.update {
//                it.copy(
//                    movies = it.movies.map {
//                        if (it.id == movie.id) {
//                            movie
//                        } else {
//                            it
//                        }
//                    }
//                )
//            }
//        }
    }

    data class UiState(
        var isLoading: Boolean = false,
        val movies: List<ServerMovie> = emptyList()
    )
}

