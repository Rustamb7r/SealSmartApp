package com.example.sealsmartapp.domain.Interactor

import com.example.sealsmartapp.domain.entities.AccountModel
import com.example.sealsmartapp.data.AppSettings
import com.example.sealsmartapp.domain.FirstRepository
import it.czerwinski.android.hilt.annotations.Bound
import javax.inject.Inject
import javax.inject.Singleton

@Bound
@Singleton
class FirstInteractorImpl @Inject constructor(
    var firstRepository: FirstRepository,
    private val appSettings: AppSettings,
) : FirstInteractor {
    var count = 0

    override suspend fun getToken(): String {
        val token  = firstRepository.signIn()
        appSettings.setCurrentToken(token)
        count++
        return when (count) {
            2 -> "Люблю тебя"
            4 -> "Сильно-Сильно"
            5 -> "С 23 февраля!!"
            else -> token
        }
    }

    override suspend fun getAccount(): AccountModel {
        return firstRepository.getAccount()
    }
}