package com.laguipemo.appdesafioarquitecturas.presentation.ui.screens.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.laguipemo.appdesafioarquitecturas.domain.model.Movie
import com.laguipemo.appdesafioarquitecturas.MoviesApplication
import com.laguipemo.appdesafioarquitecturas.R
import com.laguipemo.appdesafioarquitecturas.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapter: MainMovieAdapter
    private val mViewModel: MainViewModel by viewModels {
        MainViewModel.MainViewModelFactory((application as MoviesApplication).repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        supportActionBar?.title = "Movies"

        setupRecyclerView()
        handleUiState()

    }

    private fun setupRecyclerView() {
        mAdapter = MainMovieAdapter(
            onMovieClick = { movie -> onMovieClick(movie) },
            onMovieAction = { moviAction -> mViewModel.onMovieAction(moviAction) }
        )
        mBinding.recyclerview.apply {
            adapter = mAdapter
            layoutManager = GridLayoutManager(
                this@MainActivity, 3, GridLayoutManager.VERTICAL, false
            )
            setHasFixedSize(false)
        }
    }

    private fun handleUiState() {
        lifecycleScope.launch {
            mViewModel.state.collect {
                mBinding.progressLoading.visibility =
                    if (it.isLoading) View.VISIBLE else View.GONE
                mAdapter.submitList(it.movies)
            }
        }
    }

    private fun onMovieClick(movie: Movie) {
        Toast.makeText(this, movie.title, Toast.LENGTH_SHORT).show()
    }

}