package com.axel.example.tienda.presetantion.views.auth.roles

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axel.example.tienda.domain.model.AuthResponse
import com.axel.example.tienda.domain.usecase.auth.AuthUseCase
import com.axel.example.tienda.domain.utils.ResponseResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RolesViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel()  {
    var authResponse by mutableStateOf(AuthResponse())
    init {
        obtenerInfoSesion()
    }
    fun obtenerInfoSesion()= viewModelScope.launch {
        authUseCase.obtenerSesionInfo().collect(){data ->
            if (!data.token.isNullOrBlank()){
                authResponse = data
            }
        }
    }
}