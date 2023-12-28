package com.axel.example.tienda.domain.usecase.auth

data class AuthUseCase(
        val inicioSesion: IniciarSesionUseCase,
        val register: RegisterUseCase

)
