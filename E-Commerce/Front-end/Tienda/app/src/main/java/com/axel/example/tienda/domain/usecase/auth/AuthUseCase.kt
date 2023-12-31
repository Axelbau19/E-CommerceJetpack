package com.axel.example.tienda.domain.usecase.auth

data class AuthUseCase(
        val inicioSesion: IniciarSesionUseCase,
        val register: RegisterUseCase,
        val guardarSesion: GuardarSesionUseCase,
        val obtenerSesionInfo: ObtenerSesionInfoUseCase

)
