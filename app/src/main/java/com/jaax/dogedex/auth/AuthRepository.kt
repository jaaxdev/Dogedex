package com.jaax.dogedex.auth

import com.jaax.dogedex.api.ApiResponsesStatus
import com.jaax.dogedex.api.DogsApi
import com.jaax.dogedex.api.dto.DogDTOMapper
import com.jaax.dogedex.api.dto.SignUpDTO
import com.jaax.dogedex.api.dto.UserDTOMapper
import com.jaax.dogedex.api.makeNetworkCall
import com.jaax.dogedex.doglist.Dog
import com.jaax.dogedex.models.User

class AuthRepository {
    suspend fun signUp(email: String,
                       password: String,
                       passwordConfirmation: String): ApiResponsesStatus<User> {
        return makeNetworkCall {
            val signUpDTO = SignUpDTO(email, password, passwordConfirmation)
            val signUpResponse = DogsApi.retrofitService.signUp(signUpDTO)

            if(!signUpResponse.isSuccess) {
                throw Exception(signUpResponse.message)
            }
            val userDTO = signUpResponse.data.user
            val userDTOMapper = UserDTOMapper()
            userDTOMapper.fromUserDTOToDomain(userDTO)
        }
    }
}