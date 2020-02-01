package com.sandisetiawan444.movie.data.remote

import com.sandisetiawan444.movie.data.remote.model.Movie
import com.sandisetiawan444.network.model.BaseResponse
import retrofit2.http.GET

interface MovieService {

    @GET("discover/movie")
    suspend fun getMovies(): BaseResponse<List<Movie>?>
}