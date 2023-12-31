package com.axel.example.tienda.domain.repository

import com.axel.example.tienda.domain.model.AuthResponse
import com.axel.example.tienda.domain.utils.ResponseResource
import com.axel.example.tienda.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepositorio {
    //Login , Register ....
    //Coroutines (Utilizamos Corutinas)
    //Login (Iniciar Sesion)
    suspend fun login(email: String, password: String): ResponseResource<AuthResponse>
    suspend fun register(user: User): ResponseResource<AuthResponse>
    suspend fun guardarSesion(authResponse: AuthResponse)
    fun obtenerSesion(): Flow<AuthResponse>

}