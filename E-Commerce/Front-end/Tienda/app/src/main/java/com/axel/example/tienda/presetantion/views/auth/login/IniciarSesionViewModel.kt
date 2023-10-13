package com.axel.example.tienda.presetantion.views.auth.login


import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IniciarSesionViewModel  @Inject constructor(): ViewModel()  {
    var state by mutableStateOf(LoginState())
        private set


  fun onEmailinput(correoElectronico:String){
      state = state.copy(correoElectronico=correoElectronico)
  }
    fun onPasswordinput(contraseñaUsuario:String){
        state = state.copy(contraseñaUsuario=contraseñaUsuario)
    }
}
