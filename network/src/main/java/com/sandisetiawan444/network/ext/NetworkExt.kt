package com.sandisetiawan444.network.ext

import com.sandisetiawan444.network.model.BaseResponse
import retrofit2.HttpException
import java.net.UnknownHostException

fun <T> getExceptionResponse(e: Exception): BaseResponse<T> {
    return when (e) {
        is HttpException -> BaseResponse(false, null, null, null, e.message, null)
        is UnknownHostException -> BaseResponse(false, null, null, null, e.message, null)
        else -> BaseResponse(false, null, null, null, "Unknown error occurred", null)
    }
}