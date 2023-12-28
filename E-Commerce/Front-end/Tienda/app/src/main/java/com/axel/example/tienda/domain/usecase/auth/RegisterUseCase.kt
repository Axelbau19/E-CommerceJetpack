package com.axel.example.tienda.domain.usecase.auth

import com.axel.example.tienda.domain.model.User
import com.axel.example.tienda.domain.repository.AuthRepositorio

class RegisterUseCase(private val repository: AuthRepositorio) {
    suspend operator fun invoke(user: User) = repository.register(user);
}