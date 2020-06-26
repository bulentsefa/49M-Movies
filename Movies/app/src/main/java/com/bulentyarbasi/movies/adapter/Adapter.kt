package com.bulentyarbasi.movies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bulentyarbasi.movies.R
import com.bulentyarbasi.movies.model.Movie
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.list_movies.view.*

class Adapter(val movies: MutableList<Movie>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_movies, parent, false)
        )
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            val url =
                if (movie.posterPath != null) "https://image.tmdb.org/t/p/w342/${movie.posterPath}" else null
            Glide.with(itemView.context)
                .load(url).apply(
                    RequestOptions().centerCrop().transform(RoundedCorners(16))
                )
                .into(itemView.moviesImage)
            itemView.movieTitle.text = movie.title
            itemView.movieVote.text = movie.vote.toString()
            itemView.moviePopularity.text = String.format("Popularity : ${movie.popularity}")
            itemView.movieReleaseDate.text = String.format("Release Date : ${movie.releaseDate}")
            itemView.movieIsAdult.text =
                if (movie.isAdult) String.format("+18") else String.format("General Viewers")
        }
    }

}