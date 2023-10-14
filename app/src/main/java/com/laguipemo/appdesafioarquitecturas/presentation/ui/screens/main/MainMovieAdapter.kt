package com.laguipemo.appdesafioarquitecturas.presentation.ui.screens.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.laguipemo.appdesafioarquitecturas.domain.model.Movie
import com.laguipemo.appdesafioarquitecturas.R
import com.laguipemo.appdesafioarquitecturas.databinding.ItemMovieBinding

/**
 * Project: DesafioArquitecturas
 * from: com.laguipemo.desafioarquitecturas
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 3/10/23 at 22:09
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

class MainMovieAdapter(
    private val onMovieClick: (movie: com.laguipemo.appdesafioarquitecturas.domain.model.Movie) -> Unit,
    private val onMovieAction: (movieAction: MovieAction) -> Unit
) : ListAdapter<com.laguipemo.appdesafioarquitecturas.domain.model.Movie, MainMovieAdapter.ViewHolder>(MovieDiffCallback) {

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        return ViewHolder(
            LayoutInflater.from(mContext).inflate(R.layout.item_movie, parent, false),
            onMovieClick,
            onMovieAction
            )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }

    inner class ViewHolder(
        view: View,
        private val onMovieClick: (movie: com.laguipemo.appdesafioarquitecturas.domain.model.Movie) -> Unit,
        private val onMovieAction: (movieAction: MovieAction) -> Unit
    ) : RecyclerView.ViewHolder(view) {

        private var binding = DataBindingUtil.bind<ItemMovieBinding>(view)

        fun bind(movie: com.laguipemo.appdesafioarquitecturas.domain.model.Movie) {
            with(binding!!){
                tvMovieTitle.text = movie.title
                tvMovieVoteAvg.text = movie.voteAverage.toString()
                if (movie.isFavorite) {
                    ibFavorite.setImageResource(R.drawable.ic_favorite_full)
                } else {
                    ibFavorite.setImageResource(R.drawable.ic_favorite_empty)
                }
                Glide.with(mContext)
                    .load("https://image.tmdb.org/t/p/w500${movie.backdropPath}")
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.drawable.ic_access_time)
                    .error(R.drawable.ic_broken_image)
                    .into(ivMovieCover)

                itemView.setOnClickListener {
                    onMovieClick(movie)
                }

                ibFavorite.setOnClickListener {
                    onMovieAction(MovieAction.MovieFavoriteClick(movie))
                }
            }

        }

    }

    private object MovieDiffCallback : DiffUtil.ItemCallback<com.laguipemo.appdesafioarquitecturas.domain.model.Movie>() {
        override fun areItemsTheSame(oldItem: com.laguipemo.appdesafioarquitecturas.domain.model.Movie, newItem: com.laguipemo.appdesafioarquitecturas.domain.model.Movie): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: com.laguipemo.appdesafioarquitecturas.domain.model.Movie, newItem: com.laguipemo.appdesafioarquitecturas.domain.model.Movie): Boolean  =
            oldItem == newItem
    }

}