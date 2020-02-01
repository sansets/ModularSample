package com.sandisetiawan444.movie.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sandisetiawan444.base.ext.loadImage
import com.sandisetiawan444.movie.R
import com.sandisetiawan444.movie.data.remote.model.Movie
import com.sandisetiawan444.movie.util.UrlHelper.getPosterUrl
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by Sandi on 31/01/2020.
 */

class MovieAdapter(private val listener: MovieActionListener) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private val movies = ArrayList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind(position)

    fun setMovies(movies: List<Movie>?) {
        movies?.let {
            this.movies.apply {
                clear()
                addAll(it)
            }
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(position: Int) {
            inflateData(movies[position])
        }

        private fun inflateData(movie: Movie?) {
            itemView.img_poster.loadImage(getPosterUrl(movie?.posterPath))
            itemView.tv_title.text = movie?.title
            itemView.tv_rating.text = movie?.voteAverage.toString()
            itemView.setOnClickListener { listener.onItemMovieClicked(movie, itemView.img_poster) }
        }
    }
}