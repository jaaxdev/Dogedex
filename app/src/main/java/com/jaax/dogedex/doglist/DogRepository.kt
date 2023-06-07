package com.jaax.dogedex.doglist

import com.jaax.dogedex.api.ApiResponsesStatus
import com.jaax.dogedex.api.DogsApi
import com.jaax.dogedex.api.makeNetworkCall
import com.jaax.dogedex.api.dto.DogDTOMapper

class DogRepository {
    suspend fun downloadDogs(): ApiResponsesStatus<List<Dog>> {
        return makeNetworkCall {
            val dogListResponse = DogsApi.retrofitService.getAllDogs()
            val dogDTOList = dogListResponse.dogListResponse.listDogs
            val dogDTOMapper = DogDTOMapper()
            dogDTOMapper.fromDogDTOListToDomainList(dogDTOList)
        }
    }
}