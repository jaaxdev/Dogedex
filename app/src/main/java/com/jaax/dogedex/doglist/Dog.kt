package com.jaax.dogedex.doglist

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dog(
    val id: Long,
    val name: String,
    @SerializedName("dog_type")
    val type: String,
    @SerializedName("height_female")
    val heightFemale: String,
    @SerializedName("height_male")
    val heightMale: String,
    @SerializedName("image_url")
    val imageURL: String,
    val index: Int,
    @SerializedName("life_expectancy")
    val lifeExpectancy: String,
    @SerializedName("name_en")
    val nameEN: String,
    @SerializedName("name_es")
    val nameES: String,
    val temperament: String,
    @SerializedName("temeperament_en")
    val temperamentEN: String,
    @SerializedName("weight_female")
    val weightFemale: String,
    @SerializedName("weight_male")
    val weightMale: String,
    @SerializedName("ml_id")
    val mlID: String
): Parcelable
