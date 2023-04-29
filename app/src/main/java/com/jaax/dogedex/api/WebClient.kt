package com.jaax.dogedex.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://todogs.herokuapp.com/api/v1/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object DogsApi {
    val retrofitService: APIService by lazy {
        retrofit.create(APIService::class.java)
    }
}