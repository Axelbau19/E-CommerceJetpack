package com.axel.example.tienda.data.repository.dataSourceImplement

import com.axel.example.tienda.data.repository.dataSource.AuthDataStoreLocal
import com.axel.example.tienda.data.store.AuthDataStore
import com.axel.example.tienda.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

class AuthDataLocalStoreImplement constructor(private val authDataStore: AuthDataStore): AuthDataStoreLocal {
    override suspend fun guardarSesion(authResponse: AuthResponse) = authDataStore.guardarInformacion(authResponse)
    override fun obtenerSesion(): Flow<AuthResponse> = authDataStore.obtenerInformacion()
}