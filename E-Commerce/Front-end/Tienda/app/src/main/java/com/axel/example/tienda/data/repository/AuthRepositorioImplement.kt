package com.axel.example.tienda.data.repository


import com.axel.example.tienda.data.repository.dataSource.AuthRemoteDataSource
import com.axel.example.tienda.domain.model.AuthResponse
import com.axel.example.tienda.domain.repository.AuthRepositorio
import com.axel.example.tienda.domain.ResponseResource
import com.axel.example.tienda.domain.model.ErrorResponse
import com.axel.example.tienda.domain.utils.ConvertirErrorMensaje
import retrofit2.HttpException
import java.io.IOException

class AuthRepositorioImplement(private  val authRemoteDataSource: AuthRemoteDataSource): AuthRepositorio {
    override suspend fun login(email: String, password: String): ResponseResource<AuthResponse> {
        return try {
            val resultado = authRemoteDataSource.login(email,password)
            if(resultado.isSuccessful()){ //Petición http 201 exito
                //Opcional
                ResponseResource.Success(resultado.body()!!)
            }else{
                val  errorRespuesta: ErrorResponse? = ConvertirErrorMensaje.convertidorError(resultado.errorBody())
                ResponseResource.Failure(errorRespuesta?.mensaje?: "Error Desconocido")
            }

        }catch (e: HttpException){
            e.printStackTrace()
            ResponseResource.Failure(e.message ?: "Error en la petición de http")
        }catch (e: IOException){
            e.printStackTrace()
            ResponseResource.Failure("Verifica tu conexión a internet")
        }
        catch (e: Exception){
            e.printStackTrace()
            ResponseResource.Failure(e.message ?: "Error Desconocido")
        }
    }

}