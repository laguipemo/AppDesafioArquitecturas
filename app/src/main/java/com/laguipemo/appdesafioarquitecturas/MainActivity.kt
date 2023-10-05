package com.laguipemo.appdesafioarquitecturas

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.laguipemo.appdesafioarquitecturas.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

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

        lifecycleScope.launch {
            mViewModel.state.collect {
                mAdapter.submitList(it.movies)
            }
        }

    }

    override fun onMovieClick(movie: ServerMovie) {
        Toast.makeText(applicationContext, movie.title, Toast.LENGTH_SHORT).show()
    }
}