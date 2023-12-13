package com.axel.example.tienda.presetantion.views.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.axel.example.tienda.domain.utils.Response
import com.axel.example.tienda.presetantion.navigation.screen.AuthScreen
import com.axel.example.tienda.presetantion.views.auth.login.IniciarSesionViewModel


@Composable
fun Login( navController: NavController, vm:IniciarSesionViewModel = hiltViewModel()){
    when(val respuesta = vm.inicioRespuesta){
        Response.Loading ->{
            Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center ){
                    CircularProgressIndicator()
            }
        }
         is Response.Success -> {
            LaunchedEffect(Unit){
                navController.navigate(route = AuthScreen.Home.route)
            }
        }
         is Response.Failure -> {
            Toast.makeText(LocalContext.current,respuesta.exception.message,Toast.LENGTH_SHORT).show()
        }
         else ->{
             Toast.makeText(LocalContext.current,"Error desconocido",Toast.LENGTH_SHORT).show()
         }
    }

}