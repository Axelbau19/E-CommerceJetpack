package com.axel.example.tienda.data.repository.dataSource

import com.axel.example.tienda.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

interface AuthDataStoreLocal {
    suspend fun guardarSesion(authResponse: AuthResponse)
    fun obtenerSesion(): Flow<AuthResponse>
}