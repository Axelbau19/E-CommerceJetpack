package com.axel.example.tienda.presetantion.views.auth.login


import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IniciarSesionViewModel  @Inject constructor(): ViewModel()  {
    var state by mutableStateOf(LoginState())
        private set

    var errorMessage by mutableStateOf("")
        private set

  fun onEmailinput(correoElectronico:String){
      state = state.copy(correoElectronico=correoElectronico)
  }
    fun onPasswordinput(contraseñaUsuario:String){
        state = state.copy(contraseñaUsuario=contraseñaUsuario)
    }

    //Validaciones (validateForm)
    fun validacionForm() = viewModelScope.launch {
        if(!Patterns.EMAIL_ADDRESS.matcher(state.correoElectronico).matches()){
            errorMessage = "El email no es valido"
        }
         else if (state.contraseñaUsuario.length <= 6){
             errorMessage = "La contrasenia debe tener al menos 6 caracteres"
            delay(3000)
            errorMessage = ""
        }
    }

}
