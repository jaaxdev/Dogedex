package com.jaax.dogedex.api

import com.jaax.dogedex.doglist.Dog

sealed class ApiResponsesStatus {
    class Success(val dogList: List<Dog>): ApiResponsesStatus()
    class Loading: ApiResponsesStatus()
    class Error(val message: String): ApiResponsesStatus()
}