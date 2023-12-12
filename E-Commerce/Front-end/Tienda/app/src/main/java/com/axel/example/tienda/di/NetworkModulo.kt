package com.axel.example.tienda.di

import com.axel.example.tienda.core.Configuracion
import com.axel.example.tienda.data.api.AuthApi
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModulo {
    @Provides
    @Singleton
     fun proveerRetroFit():Retrofit{
            return Retrofit
                    .Builder()
                    .baseUrl(Configuracion.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
     }

    @Provides
    @Singleton
    fun proveerAuthApi(retrofit: Retrofit): AuthApi{
        return  retrofit.create(AuthApi::class.java)
    }
}