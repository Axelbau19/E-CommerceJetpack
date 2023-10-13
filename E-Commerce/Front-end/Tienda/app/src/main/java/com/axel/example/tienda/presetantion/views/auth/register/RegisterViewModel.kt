package com.axel.example.tienda.presetantion.views.auth.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel(){
    var state by mutableStateOf(RegisterState())
    fun onNombreInput(input:String){
        state = state.copy(nombre = input)

    }
    fun  onApellidoInput(input: String){
        state = state.copy(apellidos = input)
    }
    fun  onEmailInput(input: String){
        state = state.copy(email = input)
    }

    fun  oncontraseniaInput(input: String){
        state = state.copy(contrasenia = input)
    }
    fun onVerificarContraseniaInput(input: String){
        state = state.copy(verificarContrasenia = input)
    }

    fun onNumeroCelular(input: String){
        state = state.copy(nCelular = input)
    }

}