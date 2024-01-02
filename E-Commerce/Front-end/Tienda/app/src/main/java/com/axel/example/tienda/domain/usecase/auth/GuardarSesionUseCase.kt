package com.axel.example.tienda.domain.usecase.auth

import com.axel.example.tienda.domain.model.AuthResponse
import com.axel.example.tienda.domain.repository.AuthRepositorio

class GuardarSesionUseCase constructor(private val  repositorio: AuthRepositorio) {
     suspend operator fun invoke(authResponse: AuthResponse) = repositorio.guardarSesion(authResponse)
}