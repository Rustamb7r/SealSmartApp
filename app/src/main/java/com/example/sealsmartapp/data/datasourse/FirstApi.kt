package com.example.sealsmartapp.data.datasourse

import com.example.sealsmartapp.data.datasourse.entites.GetAccountResponseEntity
import com.example.sealsmartapp.data.datasourse.entites.SignInRequestBody
import com.example.sealsmartapp.data.datasourse.entites.SignInResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface FirstApi {

    @POST("sign-in")
    suspend fun signIn(@Body body: SignInRequestBody): SignInResponseBody

    @GET("me")
    suspend fun getAccount(): GetAccountResponseEntity
}