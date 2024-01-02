package com.axel.example.tienda.data.store

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.axel.example.tienda.core.Configuracion.AUTH_KEY
import com.axel.example.tienda.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthDataStore constructor(private val dataStore: DataStore<Preferences>){
    suspend fun guardarInformacion(authResponse: AuthResponse){
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit {pref ->
            pref[dataStoreKey] = authResponse.aJson()
        }
    }
    fun obtenerInformacion(): Flow<AuthResponse> {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
         return dataStore.data.map { pref ->
             if (pref[dataStoreKey]!=null){
                 AuthResponse.deJson(pref[dataStoreKey]!!)
             }else{
                 AuthResponse()
             }
     }
    }
}
