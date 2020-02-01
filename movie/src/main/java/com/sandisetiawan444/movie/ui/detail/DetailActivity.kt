package com.sandisetiawan444.movie.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.sandisetiawan444.base.ext.loadImage
import com.sandisetiawan444.movie.R
import com.sandisetiawan444.movie.data.remote.model.Movie
import com.sandisetiawan444.movie.util.MovieEnvironment.Extras.EXTRA_MOVIE
import com.sandisetiawan444.movie.util.MovieEnvironment.ViewAnimations.VIEW_POSTER
import com.sandisetiawan444.movie.util.UrlHelper.getBackdropUrl
import com.sandisetiawan444.movie.util.UrlHelper.getPosterUrl
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : AppCompatActivity() {

    private val mMovie: Movie? by lazy {
        intent.getParcelableExtra<Movie?>(EXTRA_MOVIE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setTransition()
        inflateData(mMovie)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun setTransition() {
        ViewCompat.setTransitionName(card_poster, VIEW_POSTER)
    }

    private fun inflateData(movie: Movie?) {
        supportActionBar?.title = movie?.title
        img_backdrop.apply {
            contentDescription = movie?.title
            loadImage(getBackdropUrl(movie?.backdropPath))
        }
        img_poster.apply {
            contentDescription = movie?.title
            loadImage(getPosterUrl(movie?.posterPath))
        }
        tv_title.text = movie?.title
        tv_vote.text = movie?.voteAverage.toString()
        tv_overview.text = movie?.overview
    }
}
