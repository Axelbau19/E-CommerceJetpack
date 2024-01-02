package com.axel.example.tienda.domain.model

import com.google.gson.Gson

data class AuthResponse(
        val user: User ?= null,
        val token: String?= null
){
    fun aJson():String = Gson().toJson(this)
    companion object{
        fun deJson(data:String): AuthResponse = Gson().fromJson(data,AuthResponse::class.java)
    }
}
