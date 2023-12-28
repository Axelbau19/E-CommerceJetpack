package com.axel.example.tienda.data.api

import com.axel.example.tienda.domain.model.AuthResponse
import com.axel.example.tienda.domain.model.User
import retrofit2.Response
import retrofit2.http.Body

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

//Creación de peticiones
interface AuthApi {
    //Para asicronar
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
            @Field("email") email: String,
            @Field("password") password: String,
    ): Response<AuthResponse>

    //Para Registrar

    @POST("auth/register")
    suspend fun register(
            @Body() user: User
    ): Response<AuthResponse>

}