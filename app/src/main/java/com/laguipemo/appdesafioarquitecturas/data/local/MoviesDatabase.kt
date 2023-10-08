package com.laguipemo.appdesafioarquitecturas.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas.data.local
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 8/10/23 at 22:44
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

@Database(entities = [LocalMovie::class], version = 1)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun moviesDao(): MoviesDao

    companion object {

        @Volatile
        private var INSTANCE: MoviesDatabase? = null

        fun getDatabase(context: Context): MoviesDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(
                context,
                MoviesDatabase::class.java,
                "movies_database")
            .build()
        }

    }
}