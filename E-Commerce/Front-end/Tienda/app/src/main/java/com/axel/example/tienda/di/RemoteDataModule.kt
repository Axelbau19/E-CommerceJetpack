package com.axel.example.tienda.di

import com.axel.example.tienda.data.api.AuthApi
import com.axel.example.tienda.data.repository.dataSource.AuthRemoteDataSource
import com.axel.example.tienda.data.repository.dataSourceImplement.AuthRemoteDataSourceImplement
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


//Implementar el dagger injection
@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    fun proveerApiRemoteData(authApi: AuthApi): AuthRemoteDataSource = AuthRemoteDataSourceImplement(authApi)
}