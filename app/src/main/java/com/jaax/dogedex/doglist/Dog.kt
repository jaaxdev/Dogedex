package com.jaax.dogedex.doglist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dog(
    val id: Long,
    val type: String,
    val heightFemale: String,
    val heightMale: String,
    val imageURL: String,
    val index: Int,
    val lifeExpectancy: String,
    val nameEN: String,
    val nameES: String,
    val temperament: String,
    val temperamentEN: String,
    val weightFemale: String,
    val weightMale: String,
    val mlID: String
) : Parcelable
