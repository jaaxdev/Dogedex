package com.jaax.dogedex.api.dto

import com.jaax.dogedex.doglist.Dog

class DogDTOMapper {
    private fun fromDogDTOToDomain(dogDTO: DogDTO): Dog {
        return Dog(
            dogDTO.id,
            dogDTO.type,
            dogDTO.heightFemale,
            dogDTO.heightMale,
            dogDTO.imageURL,
            dogDTO.index,
            dogDTO.lifeExpectancy,
            dogDTO.nameEN,
            dogDTO.nameES,
            dogDTO.temperament,
            dogDTO.temperamentEN,
            dogDTO.weightFemale,
            dogDTO.weightMale,
            dogDTO.mlID
        )
    }

    fun fromDogDTOListToDomainList(dogDTOList: List<DogDTO>): List<Dog> {
        return dogDTOList.map { fromDogDTOToDomain(it) }
    }
}