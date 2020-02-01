package com.sandisetiawan444.movie.ui

import android.widget.ImageView
import com.sandisetiawan444.movie.data.remote.model.Movie

/**
 * Created by Sandi on 31/01/2020.
 */

interface MovieActionListener {

    fun onItemMovieClicked(movie: Movie?, imageView: ImageView?)

    fun onItemSettingClicked()
}