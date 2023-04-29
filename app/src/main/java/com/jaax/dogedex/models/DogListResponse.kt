package com.jaax.dogedex.models

import com.jaax.dogedex.api.dto.DogDTO
import com.jaax.dogedex.doglist.Dog
import com.squareup.moshi.Json

data class DogListResponse(
    @field:Json(name = "dogs")
    val listDogs: List<DogDTO>
)