package com.axel.example.tienda.data.repository.dataSource

import com.axel.example.tienda.domain.model.User
import retrofit2.Response

interface AuthRemoteDataSource {
    suspend fun login(email:String, password:String): Response<User>
}