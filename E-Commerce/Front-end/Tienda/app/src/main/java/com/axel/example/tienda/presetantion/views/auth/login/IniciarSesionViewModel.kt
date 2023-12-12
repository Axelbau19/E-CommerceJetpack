package com.axel.example.tienda.presetantion.views.auth.login


import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axel.example.tienda.domain.model.User
import com.axel.example.tienda.domain.utils.Response
import com.axel.example.tienda.domain.usecase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IniciarSesionViewModel  @Inject constructor(private val authUseCase:AuthUseCase): ViewModel()  {
    var state by mutableStateOf(LoginState())
        //Evitar que sea alterado desde otra clase
        private set

    var errorMessage by mutableStateOf("")
        private set
  // Respuesta al iniciar sesion
  var inicioRespuesta by mutableStateOf<Response<User>?>(null)
      private set

  fun inicioSesion() = viewModelScope.launch {
      if(validacionForm()){
          inicioRespuesta = Response.Loading
          val respuestaConexion = authUseCase.inicioSesion(state.correoElectronico,state.contraseñaUsuario)
          inicioRespuesta = respuestaConexion
          Log.d("IniciarSesionViewModel", "Respuesta:${inicioRespuesta}")
      }

  }

  fun onEmailinput(correoElectronico:String){
      state = state.copy(correoElectronico=correoElectronico)
  }
    fun onPasswordinput(contraseñaUsuario:String){
        state = state.copy(contraseñaUsuario=contraseñaUsuario)
    }

    //Validaciones (validateForm)
    fun validacionForm(): Boolean {
        if(!Patterns.EMAIL_ADDRESS.matcher(state.correoElectronico).matches()){
            errorMessage = "El email no es valido"
            return false
        }
         else if (state.contraseñaUsuario.length <= 6){
             errorMessage = "La contrasenia debe tener al menos 6 caracteres"
            return false
        }
        return true
    }

}
