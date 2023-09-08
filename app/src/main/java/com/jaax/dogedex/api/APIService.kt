package com.jaax.dogedex.api

import com.jaax.dogedex.api.dto.SignUpDTO
import com.jaax.dogedex.models.DogListApiResponse
import com.jaax.dogedex.models.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService {
    @GET("dogs")
    suspend fun getAllDogs(): DogListApiResponse

    @POST("signup")
    suspend fun signUp(@Body sigunUpDto: SignUpDTO): SignUpResponse
}