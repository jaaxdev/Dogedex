package com.jaax.dogedex.models

import com.google.gson.annotations.SerializedName

data class DogListApiResponse(
    val message: String,
    @SerializedName("is_success")
    val isSuccess: Boolean,
    @SerializedName("data")
    val dogListResponse: DogListResponse
)