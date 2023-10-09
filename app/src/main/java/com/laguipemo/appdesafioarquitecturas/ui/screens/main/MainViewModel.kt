package com.laguipemo.appdesafioarquitecturas.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.laguipemo.appdesafioarquitecturas.Movie
import com.laguipemo.appdesafioarquitecturas.data.local.MoviesDao
import com.laguipemo.appdesafioarquitecturas.data.local.toMovie
import com.laguipemo.appdesafioarquitecturas.data.remote.MoviesService
import com.laguipemo.appdesafioarquitecturas.data.remote.ServerMovie
import com.laguipemo.appdesafioarquitecturas.data.remote.toLocalMovie
import com.laguipemo.appdesafioarquitecturas.toLocalMovie
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

class MainViewModel(
    private val dao: MoviesDao
) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            //if dabase is empty, populate it
            if (dao.getCount() == 0) {
                _state.update {
                    it.copy(
                        isLoading = true
                    )
                }
                dao.insertMovies(Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(MoviesService::class.java)
                    .getMovies()
                    .results
                    .map { it.toLocalMovie() }
                )

            }
            _state.update {
                it.copy(
                    isLoading = false,
                    movies = dao.getMovies().map { it.toMovie() }
                )
            }

        }
    }

    fun onMovieAction(movieAction: MovieAction) {
        when (movieAction) {
            is MovieAction.MovieFavoriteClick -> {
                viewModelScope.launch {
                    dao.updateMovie(movieAction.movie.copy(
                        isFavorite = !movieAction.movie.isFavorite
                    ).toLocalMovie())
                    _state.update {
                        it.copy(
                            movies = it.movies.map {
                                if (it.id == movieAction.movie.id) {
                                    movieAction.movie.copy(isFavorite = !movieAction.movie.isFavorite)
                                } else {
                                    it
                                }
                            }
                        )
                    }
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

    class MainViewModelFactory(private val dao: MoviesDao) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(dao) as T
            } else {
                throw IllegalArgumentException("ViewModel Not Found")
            }
        }
    }
}

