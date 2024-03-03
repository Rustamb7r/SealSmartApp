package com.example.sealsmartapp.data.datasourse.entites

import com.example.sealsmartapp.domain.entities.AccountModel

data class GetAccountResponseEntity(
    val id: Long,
    val email: String,
    val username: String,
    val createdAt: Long
) {
    fun toDomain(): AccountModel = AccountModel(
        id = id,
        email = email,
        username = username,
        createdAt = createdAt
    )
}

