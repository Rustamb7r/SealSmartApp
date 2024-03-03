package com.example.sealsmartapp.domain

import com.example.sealsmartapp.domain.entities.AccountModel


interface FirstRepository {

    suspend fun signIn(): String

    suspend fun getAccount(): AccountModel
}