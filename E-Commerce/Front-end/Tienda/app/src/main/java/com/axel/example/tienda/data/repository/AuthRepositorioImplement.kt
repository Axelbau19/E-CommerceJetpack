package com.axel.example.tienda.data.repository

import com.axel.example.tienda.data.repository.dataSource.AuthRemoteDataSource
import com.axel.example.tienda.domain.model.AuthResponse
import com.axel.example.tienda.domain.repository.AuthRepositorio
import com.axel.example.tienda.domain.utils.ResponseResource

class AuthRepositorioImplement(private  val authRemoteDataSource: AuthRemoteDataSource): AuthRepositorio {
    override suspend fun login(email: String, password: String): ResponseResource<AuthResponse> {
        return try {
            val resultado = authRemoteDataSource.login(email,password)
            //Opcional
            ResponseResource.Success(resultado.body()!!)
        }catch (e: Exception){
            //Log.d("IniciarsesionViewModelImpt","Error"+e)
            e.printStackTrace()
            ResponseResource.Failure(e)
        }
    }

}