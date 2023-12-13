package com.axel.example.tienda.domain.model

data class AuthResponse(
        val user: User,
        val token: String
)
