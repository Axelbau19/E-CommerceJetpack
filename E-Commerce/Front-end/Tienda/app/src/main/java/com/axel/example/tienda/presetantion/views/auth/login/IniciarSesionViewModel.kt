package com.axel.example.tienda.presetantion.views.auth.login


import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IniciarSesionViewModel  @Inject constructor(): ViewModel()  {
    var correoElectronico by  mutableStateOf("")
    var contraseñaUsuario by mutableStateOf("")
}
