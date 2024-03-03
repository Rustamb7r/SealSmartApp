package com.example.sealsmartapp.domain.Interactor

import com.example.sealsmartapp.domain.entities.AccountModel


interface FirstInteractor {

    suspend fun getToken(): String

    suspend fun getAccount(): AccountModel
}