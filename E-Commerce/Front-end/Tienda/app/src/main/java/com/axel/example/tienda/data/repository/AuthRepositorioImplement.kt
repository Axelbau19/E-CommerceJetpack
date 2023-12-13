package com.axel.example.tienda.data.repository

import com.axel.example.tienda.data.repository.dataSource.AuthRemoteDataSource
import com.axel.example.tienda.domain.model.AuthResponse
import com.axel.example.tienda.domain.model.User
import com.axel.example.tienda.domain.repository.AuthRepositorio
import com.axel.example.tienda.domain.utils.Response

class AuthRepositorioImplement(private  val authRemoteDataSource: AuthRemoteDataSource): AuthRepositorio {
    override suspend fun login(email: String, password: String): Response<AuthResponse> {
        return try {
            val resultado = authRemoteDataSource.login(email,password)
            //Opcional
            Response.Success(resultado.body()!!)
        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }

}