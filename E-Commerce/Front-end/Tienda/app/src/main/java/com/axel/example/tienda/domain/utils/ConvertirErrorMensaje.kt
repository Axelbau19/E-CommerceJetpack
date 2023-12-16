package com.axel.example.tienda.domain.utils

import android.util.Log
import com.axel.example.tienda.domain.model.ErrorResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.ResponseBody

object ConvertirErrorMensaje {

    fun convertidorError(errorMensajes:ResponseBody?): ErrorResponse?{
        return  try {
                errorMensajes?.source()?.let {
                val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
                val moshiAdaptador = moshi.adapter(ErrorResponse::class.java)
                moshiAdaptador.fromJson(it)
                
            }
        }
        catch (e: Exception){
            Log.d("ConvertirErrorMensaje","Error"+e.message)
            null
        }
    }
}