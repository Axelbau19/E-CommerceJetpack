package com.axel.example.tienda.data.repository.dataSource

import com.axel.example.tienda.domain.model.AuthResponse
import com.axel.example.tienda.domain.model.User
import retrofit2.Response

interface AuthRemoteDataSource {
    suspend fun login(email:String, password:String): Response<AuthResponse>
    suspend fun register(user: User): Response<AuthResponse>
}