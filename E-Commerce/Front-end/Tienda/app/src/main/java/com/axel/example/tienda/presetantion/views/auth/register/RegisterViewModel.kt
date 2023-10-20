package com.axel.example.tienda.presetantion.views.auth.register

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel(){
    var state by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf("")
        private set


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

    fun validacionForm() = viewModelScope.launch {
        if (state.nombre ==""){
            errorMessage = "Ingrese el nombre"
        }

        else if(state.apellidos == ""){
            errorMessage = "Ingrese los apellidos"
        }
        else if(state.email == ""){
            errorMessage = "Ingrese el correo electrónico"
        }

        else if (state.contrasenia == ""){
            errorMessage = "Ingrese la contraseña"
        }

        else if(state.verificarContrasenia==""){
            errorMessage = "Ingresa la contraseña de confirmación"
        }

        else if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "El email no es valido"
        }
        else if (state.contrasenia.length <= 6){
            errorMessage = "La contrasenia debe tener al menos 6 caracteres"
            delay(3000)
            errorMessage = ""
        }
        else if (state.contrasenia != state.verificarContrasenia){
            errorMessage = "Las contraseñas no coinciden"
        }
        else if (state.nCelular == ""){
            errorMessage = " Ingrese numero celular celular"
        }
        delay(3000)
        errorMessage = ""
    }


}