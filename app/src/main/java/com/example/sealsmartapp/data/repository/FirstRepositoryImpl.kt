package com.example.sealsmartapp.data.repository

import android.util.Log
import com.example.sealsmartapp.domain.entities.AccountModel
import com.example.sealsmartapp.data.datasourse.FirstApi
import com.example.sealsmartapp.data.datasourse.entites.SignInRequestBody
import com.example.sealsmartapp.domain.FirstRepository
import it.czerwinski.android.hilt.annotations.Bound
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Bound
@Singleton
class FirstRepositoryImpl @Inject constructor(
    retrofit: Retrofit
) : FirstRepository {

    private val firstApi = retrofit.create(FirstApi::class.java)

    override suspend fun signIn(): String {
        return try {
            val requestBody = SignInRequestBody(
                email = "admin@google.com",
                password = "123"
            )
            firstApi.signIn(requestBody).token


        } catch (e: Exception) {
            Log.d("Error", "In firstRepository")
            throw e
        }
    }

    override suspend fun getAccount(): AccountModel {
        return try {
            firstApi.getAccount().toDomain()
        } catch (e: Exception) {
            throw e
        }
    }
}