package com.jaax.dogedex.api

import com.jaax.dogedex.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

suspend fun <T> makeNetworkCall(call: suspend () -> T): ApiResponsesStatus<T> {
    return withContext(Dispatchers.IO) {
        try {
            ApiResponsesStatus.Success(call())
        } catch(e: UnknownHostException) {
            ApiResponsesStatus.Error(R.string.unknown_error_host)
        } catch(e: Exception) {
            when(e.message) {
                "signup_error" -> R.string.signup_error
                "signin_error" -> R.string.signin_error
                "user_already_exists" -> R.string.user_already_exists
                else -> R.string.unknown_error
            }
            ApiResponsesStatus.Error(R.string.unknown_error)
        }
    }
}