package com.jaax.dogedex.models

import com.jaax.dogedex.api.responses.UserResponse
import com.squareup.moshi.Json

class SignUpResponse(
    val message: String,
    @field:Json(name = "is_success")
    val isSuccess: Boolean,
    val data: UserResponse
)