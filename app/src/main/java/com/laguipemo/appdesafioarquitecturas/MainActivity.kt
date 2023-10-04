package com.laguipemo.appdesafioarquitecturas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.laguipemo.appdesafioarquitecturas.databinding.ActivityMainBinding
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), OnMovieListener {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapter: MovieAdapter
    private val mMovieList = mutableListOf<ServerMovie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mAdapter = MovieAdapter(this)
        mBinding.recyclerview.apply {
            adapter = mAdapter
            layoutManager = GridLayoutManager(
                this@MainActivity, 3, GridLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
        }

        runBlocking {
            val newMovieList = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MoviesService::class.java)
                .getMovies()
                .results
//                .forEach {
//                    Log.i("CHACHY", it.title)
//                }
            mAdapter.submitList(newMovieList)
            mAdapter.notifyDataSetChanged()

        }

    }

    override fun onMovieClick(movie: ServerMovie) {
        Toast.makeText(applicationContext, movie.title, Toast.LENGTH_SHORT).show()
    }
}