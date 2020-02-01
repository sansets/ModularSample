package com.sandisetiawan444.movie.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.sandisetiawan444.base.ui.BaseViewModel
import com.sandisetiawan444.movie.data.MovieRepository
import com.sandisetiawan444.movie.data.remote.model.Movie
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewModel @Inject constructor() : BaseViewModel() {

    @Inject
    lateinit var mRepository: MovieRepository

    private val _movies = MutableLiveData<List<Movie>>()
    var movies: LiveData<List<Movie>> = Transformations.map(_movies) { it }

    fun getMovies() = launch {
        _showProgress.value = true

        mRepository.getMovies().let {
            if (it.status != true) {
                _message.value = it.message
            }

            _movies.value = it.data
        }

        _showProgress.value = false
    }
}