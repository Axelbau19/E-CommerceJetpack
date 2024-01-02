package com.axel.example.tienda.domain.usecase.auth

import com.axel.example.tienda.domain.repository.AuthRepositorio

class ObtenerSesionInfoUseCase constructor( private val  repositorio: AuthRepositorio) {
    operator fun invoke() =  repositorio.obtenerSesion()
}