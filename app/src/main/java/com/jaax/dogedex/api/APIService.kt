package com.jaax.dogedex.api

import com.jaax.dogedex.models.DogListApiResponse
import retrofit2.http.GET

interface APIService {
    @GET("dogs")
    suspend fun getAllDogs(): DogListApiResponse
}