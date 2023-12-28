package com.axel.example.tienda.domain.utils

import com.axel.example.tienda.domain.model.ErrorResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

object ResponseToRequest {
    fun <T> enviar(resultado: Response<T>): ResponseResource<T>{
        return try {
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