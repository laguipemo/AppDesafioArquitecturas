package com.laguipemo.appdesafioarquitecturas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
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

    private val _state = MutableLiveData(UiState())
    val state: LiveData<UiState> = _state

    init {
        viewModelScope.launch {
            _state.value = _state.value?.copy(isLoading = true)
            delay(3000)
            _state.value = _state.value?.copy(
                movies = Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(MoviesService::class.java)
                    .getMovies()
                    .results
            )
            _state.value = _state.value?.copy(isLoading = false)
        }
    }

    data class UiState(
        var isLoading: Boolean = false,
        val movies: List<ServerMovie> = emptyList()
    )
}

