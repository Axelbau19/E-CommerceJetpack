package com.axel.example.tienda.domain.utils
//Creacion de 3 estados
sealed class ResponseResource<out T>{
    //Inicializar por defecto
    object Loading:  ResponseResource<Nothing>()
    //Obtener los resultados
    data class Success<out T>(val data: T): ResponseResource<T>()
    //Respuesta en caso de que falle el back-end
    data class Failure<out T>(val mensajeError: String): ResponseResource<T>()
}