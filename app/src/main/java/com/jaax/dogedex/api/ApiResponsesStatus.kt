package com.jaax.dogedex.api

import com.jaax.dogedex.doglist.Dog

sealed class ApiResponsesStatus<T> {
    class Success<T>(val data: T): ApiResponsesStatus<T>()
    class Loading<T>: ApiResponsesStatus<T>()
    class Error<T>(val messageId: Int): ApiResponsesStatus<T>()
}