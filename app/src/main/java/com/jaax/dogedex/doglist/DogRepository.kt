package com.jaax.dogedex.doglist

import com.jaax.dogedex.api.DogsApi
import com.jaax.dogedex.api.dto.DogDTOMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {
    suspend fun downloadDogs(): List<Dog> {
        return withContext(Dispatchers.IO) {
            val dogListResponse = DogsApi.retrofitService.getAllDogs()
            val dogDTOList = dogListResponse.dogListResponse.listDogs
            val dogDTOMapper = DogDTOMapper()
            dogDTOMapper.fromDogDTOListToDomainList(dogDTOList)
        }
    }
}