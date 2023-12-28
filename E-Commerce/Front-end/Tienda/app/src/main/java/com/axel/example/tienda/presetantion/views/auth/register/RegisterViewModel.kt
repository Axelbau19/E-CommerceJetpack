package com.axel.example.tienda.presetantion.views.auth.register

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axel.example.tienda.domain.utils.ResponseResource
import com.axel.example.tienda.domain.model.AuthResponse
import com.axel.example.tienda.domain.model.User
import com.axel.example.tienda.domain.usecase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel(){
    var state by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf("")

    var registerResponsee by mutableStateOf<ResponseResource<AuthResponse>?>(null)
        private set

    fun register() = viewModelScope.launch {
        if(validacionForm()){
            registerResponsee = ResponseResource.Loading
            val user = User(
                    name = state.nombre,
                    lastname = state.apellidos,
                    email = state.email,
                    phone = state.nCelular,
                    password = state.contrasenia
            )
            val resultado = authUseCase.register(user)
            registerResponsee = resultado
        }
    }


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

    fun validacionForm():Boolean{
        if (state.nombre ==""){
            errorMessage = "Ingrese el nombre"
            return false
        }

        else if(state.apellidos == ""){
            errorMessage = "Ingrese los apellidos"
            return false
        }
        else if(state.email == ""){
            errorMessage = "Ingrese el correo electrónico"
            return false

        }

        else if (state.contrasenia == ""){
            errorMessage = "Ingrese la contraseña"
            return false
        }

        else if(state.verificarContrasenia==""){
            errorMessage = "Ingresa la contraseña de confirmación"
            return false
        }

        else if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "El email no es valido"
            return false
        }
        else if (state.contrasenia.length < 6){
            errorMessage = "La contrasenia debe tener al menos 6 caracteres"
            return false
        }
        else if (state.contrasenia != state.verificarContrasenia){
            errorMessage = "Las contraseñas no coinciden"
            return false
        }
        else if (state.nCelular == ""){
            errorMessage = " Ingrese numero celular celular"
            return false
        }
        return true
    }


}