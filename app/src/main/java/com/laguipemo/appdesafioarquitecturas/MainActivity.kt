package com.laguipemo.appdesafioarquitecturas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.laguipemo.appdesafioarquitecturas.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), OnMovieListener {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapter: MovieAdapter
    private val mViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        supportActionBar?.title = "Movies"

        mAdapter = MovieAdapter(this)
        mBinding.recyclerview.apply {
            adapter = mAdapter
            layoutManager = GridLayoutManager(
                this@MainActivity, 3, GridLayoutManager.VERTICAL, false)
            setHasFixedSize(false)
        }

        mViewModel.state.observe(this) {
            mAdapter.submitList(it.movies)
        }

    }

    override fun onMovieClick(movie: ServerMovie) {
        Toast.makeText(applicationContext, movie.title, Toast.LENGTH_SHORT).show()
    }
}