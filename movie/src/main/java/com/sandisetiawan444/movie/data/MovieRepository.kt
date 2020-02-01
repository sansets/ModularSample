package com.sandisetiawan444.movie.data

import com.sandisetiawan444.movie.data.remote.model.Movie
import com.sandisetiawan444.network.model.BaseResponse

interface MovieRepository {

    suspend fun getMovies(): BaseResponse<List<Movie>?>
}