package com.jaax.dogedex.models

import com.google.gson.annotations.SerializedName
import com.jaax.dogedex.doglist.Dog

data class DogListResponse(
    @SerializedName("dogs")
    val listDogs: List<Dog>
)