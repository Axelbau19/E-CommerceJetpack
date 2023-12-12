package com.axel.example.tienda.domain.usecase.auth

import com.axel.example.tienda.domain.repository.AuthRepositorio

class IniciarSesionUseCase(private val repositorio: AuthRepositorio) {
   suspend operator fun invoke(email: String, password: String) = repositorio.login(email,password)
}