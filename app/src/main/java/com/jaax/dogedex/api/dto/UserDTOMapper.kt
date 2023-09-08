package com.jaax.dogedex.api.dto

import com.jaax.dogedex.models.User

class UserDTOMapper {
    public fun fromUserDTOToDomain(user: UserDTO): User {
        return User(
            user.id,
            user.email,
            user.authenticationToken
        )
    }
}