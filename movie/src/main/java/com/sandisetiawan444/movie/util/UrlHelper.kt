package com.sandisetiawan444.movie.util

/**
 * Created by Sandi on 31/01/2020.
 */

object UrlHelper {

    fun getPosterUrl(path: String?): String {
        return "https://image.tmdb.org/t/p/w342/$path"
    }

    fun getBackdropUrl(path: String?): String {
        return "https://image.tmdb.org/t/p/w780/$path"
    }
}