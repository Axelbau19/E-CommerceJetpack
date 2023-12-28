package com.axel.example.tienda.presetantion.views.auth.register.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.axel.example.tienda.domain.utils.ResponseResource
import com.axel.example.tienda.presetantion.components.progressBar
import com.axel.example.tienda.presetantion.navigation.screen.AuthScreen
import com.axel.example.tienda.presetantion.views.auth.register.RegisterViewModel

@Composable
fun Register(navHostController: NavHostController, vm: RegisterViewModel = hiltViewModel()){
    when(val response = vm.registerResponsee ){
        ResponseResource.Loading -> {progressBar()}
        is ResponseResource.Success -> {
            LaunchedEffect(Unit){
                navHostController.navigate(route = AuthScreen.Home.route)
            }
        }
        is ResponseResource.Failure -> {
            Toast.makeText(LocalContext.current,response.mensajeError, Toast.LENGTH_LONG).show()
        }
        else -> {
            if(response != null){
                Toast.makeText(LocalContext.current,"Error Desconocido",Toast.LENGTH_LONG).show()
            }
        }
    }
}
