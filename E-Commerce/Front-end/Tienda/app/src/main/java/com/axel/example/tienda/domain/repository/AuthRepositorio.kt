package com.axel.example.tienda.domain.repository

import com.axel.example.tienda.domain.model.AuthResponse
import com.axel.example.tienda.domain.utils.ResponseResource

interface AuthRepositorio {
    //Login , Register ....
    //Coroutines (Utilizamos Corutinas)
    //Login (Iniciar Sesion)
    suspend fun login(email: String, password: String): ResponseResource<AuthResponse>

}