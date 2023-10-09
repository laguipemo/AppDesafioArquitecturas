package com.laguipemo.appdesafioarquitecturas.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas.data.local
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 8/10/23 at 22:38
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

@Dao
interface MoviesDao {

    @Query("SELECT * FROM LocalMovie")
    fun getMovies(): Flow<List<LocalMovie>>

    @Insert
    suspend fun insertMovie(movie: LocalMovie)

    @Insert
    suspend fun insertMovies(movies: List<LocalMovie>)

    @Update
    suspend fun updateMovie(movie: LocalMovie)


    @Query("SELECT COUNT(*) FROM LocalMovie")
    suspend fun getCount(): Int
}