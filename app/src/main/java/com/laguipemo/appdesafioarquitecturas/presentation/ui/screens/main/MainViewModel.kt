package com.laguipemo.appdesafioarquitecturas.presentation.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.laguipemo.appdesafioarquitecturas.domain.model.Movie
import com.laguipemo.appdesafioarquitecturas.data.MoviesRepository
import com.laguipemo.appdesafioarquitecturas.usecases.ReadMoviesUseCases
import com.laguipemo.appdesafioarquitecturas.usecases.RequestMovieUseCase
import com.laguipemo.appdesafioarquitecturas.usecases.UpdateMovieUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 4/10/23 at 22:08
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

class MainViewModel(
    private val requestMovieUseCase: RequestMovieUseCase,
    private val readMoviesUseCases: ReadMoviesUseCases,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update {it.copy(isLoading = true)}
            requestMovieUseCase()
            readMoviesUseCases().collect { movies ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        movies = movies
                    )
                }
            }
        }
    }

    fun onMovieAction(movieAction: MovieAction) {
        when (movieAction) {
            is MovieAction.MovieFavoriteClick -> {
                viewModelScope.launch {
                    updateMovieUseCase(
                        movieAction.movie.copy(
                            isFavorite = !movieAction.movie.isFavorite
                        )
                    )
                }
            }

            is MovieAction.MovieDeleteClick -> {}

            is MovieAction.MovieShareClick -> {}
        }
    }

    data class UiState(
        var isLoading: Boolean = false,
        val movies: List<Movie> = emptyList()
    )

    class MainViewModelFactory(
        private val requestMovieUseCase: RequestMovieUseCase,
        private val readMoviesUseCases: ReadMoviesUseCases,
        private val updateMovieUseCase: UpdateMovieUseCase
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(
                    requestMovieUseCase, readMoviesUseCases, updateMovieUseCase
                ) as T
            } else {
                throw IllegalArgumentException("ViewModel Not Found")
            }
        }
    }
}

