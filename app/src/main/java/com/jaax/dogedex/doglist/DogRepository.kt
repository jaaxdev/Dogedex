package com.jaax.dogedex.doglist

import com.jaax.dogedex.api.ApiResponsesStatus
import com.jaax.dogedex.api.DogsApi
import com.jaax.dogedex.api.dto.DogDTOMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

class DogRepository {
    suspend fun downloadDogs(): ApiResponsesStatus {
        return withContext(Dispatchers.IO) {
            try {
                val dogListResponse = DogsApi.retrofitService.getAllDogs()
                val dogDTOList = dogListResponse.dogListResponse.listDogs
                val dogDTOMapper = DogDTOMapper()
                ApiResponsesStatus.Success(dogDTOMapper.fromDogDTOListToDomainList(dogDTOList))
            } catch(e: UnknownHostException) {
                ApiResponsesStatus.Error("Error de descarga, no internet")
            } catch(e: Exception) {
                ApiResponsesStatus.Error("Error desconocido")
            }
        }
    }
}