package com.axel.example.tienda.di

import com.axel.example.tienda.data.api.AuthApi
import com.axel.example.tienda.data.repository.dataSource.AuthRemoteDataSource
import com.axel.example.tienda.data.repository.dataSourceImplement.AuthRemoteDataSourceImplement
import com.axel.example.tienda.domain.repository.AuthRepositorio
import com.axel.example.tienda.domain.usecase.auth.AuthUseCase
import com.axel.example.tienda.domain.usecase.auth.IniciarSesionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


//Implementar el dagger injection
@Module
@InstallIn(SingletonComponent::class)
object UseCaseModulo {
    @Provides
    fun proveerInformacionAuthCase(authRepositorio: AuthRepositorio) = AuthUseCase(
            inicioSesion = IniciarSesionUseCase(authRepositorio)
    )

}