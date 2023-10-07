package com.laguipemo.appdesafioarquitecturas

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
import com.laguipemo.appdesafioarquitecturas.databinding.ItemMovieBinding

/**
 * Project: DesafioArquitecturas
 * from: com.laguipemo.desafioarquitecturas
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 3/10/23 at 22:09
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/

class MovieAdapter(
    private val onFavoriteClick: (movie: ServerMovie) -> Unit
) : ListAdapter<ServerMovie, MovieAdapter.ViewHolder>(MovieDiffCallback) {

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        return ViewHolder(
            LayoutInflater.from(mContext).inflate(R.layout.item_movie, parent, false),
            onFavoriteClick
            )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }

    inner class ViewHolder(
        view: View,
        private val onFavoriteClick: (movie: ServerMovie) -> Unit
    ) : RecyclerView.ViewHolder(view) {

        private var binding = DataBindingUtil.bind<ItemMovieBinding>(view)

        fun bind(movie: ServerMovie) {
            with(binding!!){
                tvMovieTitle.text = movie.title
                tvMovieVoteAvg.text = movie.vote_average.toString()
                if (movie.isFavorite) {
                    ibFavorite.setImageResource(R.drawable.ic_favorite_full)
                } else {
                    ibFavorite.setImageResource(R.drawable.ic_favorite_empty)
                }
                Glide.with(mContext)
                    .load("https://image.tmdb.org/t/p/w500${movie.backdrop_path}")
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.drawable.ic_access_time)
                    .error(R.drawable.ic_broken_image)
                    .into(ivMovieCover)

                ibFavorite.setOnClickListener {
                    onFavoriteClick(movie)
                }
            }

        }

    }

}

private object MovieDiffCallback : DiffUtil.ItemCallback<ServerMovie>() {
    override fun areItemsTheSame(oldItem: ServerMovie, newItem: ServerMovie): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ServerMovie, newItem: ServerMovie): Boolean  =
        oldItem == newItem
}