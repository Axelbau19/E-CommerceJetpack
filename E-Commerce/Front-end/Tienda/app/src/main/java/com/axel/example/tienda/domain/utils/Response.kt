package com.axel.example.tienda.domain.utils
//Creacion de 3 estados
sealed class Response<out T>{
    //Inicializar por defecto
    object Loading:  Response<Nothing>()
    //Obtener los resultados
    data class Success<out T>(val data: T): Response<T>()
    //Respuesta en caso de que falle el back-end
    data class Failure<out T>(val exception: Exception): Response<T>()
}