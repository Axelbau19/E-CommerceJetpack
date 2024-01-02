package com.axel.example.tienda.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.axel.example.tienda.core.Configuracion
import com.axel.example.tienda.data.store.AuthDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    @Provides
    @Singleton
    fun proveeDataStore(@ApplicationContext context: Context):DataStore<Preferences> = PreferenceDataStoreFactory.create(
            produceFile = {
                context.preferencesDataStoreFile(Configuracion.AUTH_PREFERENCE)
            }
    )

    @Provides
    @Singleton
    fun proveerAuthDataStore(dataStore: DataStore<Preferences>) = AuthDataStore(dataStore)
}