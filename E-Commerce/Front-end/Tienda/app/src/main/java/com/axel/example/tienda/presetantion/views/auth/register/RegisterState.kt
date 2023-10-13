package com.axel.example.tienda.presetantion.views.auth.register

data class RegisterState(
    val nombre:String = "",
    val apellidos:String="",
    val email:String="",
    val contrasenia:String="",
    val verificarContrasenia:String="",
    val nCelular:String=""
)
