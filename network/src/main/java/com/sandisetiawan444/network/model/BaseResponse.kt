package com.sandisetiawan444.network.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<D>(

    @SerializedName("status")
    val status: Boolean?,

    @SerializedName("page")
    val page: Int?,

    @SerializedName("total_results")
    val totalResults: Int?,

    @SerializedName("total_pages")
    val totalPages: Int?,

    @SerializedName("message")
    val message: String?,

    @SerializedName("results")
    val data: D?
)