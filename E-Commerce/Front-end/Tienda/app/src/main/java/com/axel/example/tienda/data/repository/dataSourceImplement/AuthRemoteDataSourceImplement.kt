package com.axel.example.tienda.data.repository.dataSourceImplement

import com.axel.example.tienda.data.api.AuthApi
import com.axel.example.tienda.data.repository.dataSource.AuthRemoteDataSource
import com.axel.example.tienda.domain.model.AuthResponse
import com.axel.example.tienda.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImplement(private val authApi: AuthApi ): AuthRemoteDataSource {

    override suspend fun login(email:String,password:String) = authApi.login(email,password)
    override suspend fun register(user: User): Response<AuthResponse> = authApi.register(user)
}