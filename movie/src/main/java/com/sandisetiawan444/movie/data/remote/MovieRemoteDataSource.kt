package com.sandisetiawan444.movie.data.remote

import com.sandisetiawan444.movie.data.remote.model.Movie
import com.sandisetiawan444.network.ext.getExceptionResponse
import com.sandisetiawan444.network.model.BaseResponse

class MovieRemoteDataSource(private val mMovieService: MovieService) {

    suspend fun getMovies(): BaseResponse<List<Movie>?> {
        return try {
            mMovieService.getMovies()
        } catch (e: Exception) {
            getExceptionResponse(e)
        }
    }
}