package com.jaax.dogedex.api.dto

import com.squareup.moshi.Json

class DogDTO(
    val id: Long,
    @field:Json(name = "dog_type")
    val type: String,
    @field:Json(name = "height_female")
    val heightFemale: String,
    @field:Json(name = "height_male")
    val heightMale: String,
    @field:Json(name = "image_url")
    val imageURL: String,
    val index: Int,
    @field:Json(name = "life_expectancy")
    val lifeExpectancy: String,
    @field:Json(name = "name_en")
    val nameEN: String,
    @field:Json(name = "name_es")
    val nameES: String,
    val temperament: String,
    @field:Json(name = "temperament_en")
    val temperamentEN: String,
    @field:Json(name = "weight_female")
    val weightFemale: String,
    @field:Json(name = "weight_male")
    val weightMale: String,
    @field:Json(name = "ml_id")
    val mlID: String
)