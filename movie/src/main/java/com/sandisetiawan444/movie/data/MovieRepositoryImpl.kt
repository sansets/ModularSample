package com.sandisetiawan444.movie.data

import com.sandisetiawan444.movie.data.remote.MovieRemoteDataSource
import com.sandisetiawan444.movie.data.remote.model.Movie
import com.sandisetiawan444.network.model.BaseResponse

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource
) : MovieRepository {

    override suspend fun getMovies(): BaseResponse<List<Movie>?> {
        return movieRemoteDataSource.getMovies()
    }
}