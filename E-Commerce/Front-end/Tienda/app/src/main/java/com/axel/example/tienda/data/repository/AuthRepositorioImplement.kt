package com.axel.example.tienda.data.repository


import com.axel.example.tienda.data.repository.dataSource.AuthDataStoreLocal
import com.axel.example.tienda.data.repository.dataSource.AuthRemoteDataSource
import com.axel.example.tienda.domain.model.AuthResponse
import com.axel.example.tienda.domain.repository.AuthRepositorio
import com.axel.example.tienda.domain.utils.ResponseResource
import com.axel.example.tienda.domain.model.ErrorResponse
import com.axel.example.tienda.domain.model.User
import com.axel.example.tienda.domain.utils.ConvertirErrorMensaje
import com.axel.example.tienda.domain.utils.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException

class AuthRepositorioImplement(private  val authRemoteDataSource: AuthRemoteDataSource,
        private val authLocalData:AuthDataStoreLocal): AuthRepositorio {
    override suspend fun login(email: String, password: String): ResponseResource<AuthResponse> = ResponseToRequest.enviar(
            authRemoteDataSource.login(email,password)
    )

    override suspend fun register(user: User): ResponseResource<AuthResponse> = ResponseToRequest.enviar(
            authRemoteDataSource.register(user)
    )

    override suspend fun guardarSesion(authResponse: AuthResponse) = authLocalData.guardarSesion(authResponse)

    override fun obtenerSesion(): Flow<AuthResponse> = authLocalData.obtenerSesion()


}