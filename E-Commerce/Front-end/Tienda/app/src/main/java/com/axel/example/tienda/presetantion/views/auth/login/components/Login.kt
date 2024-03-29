package com.axel.example.tienda.presetantion.views.auth.login.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.axel.example.tienda.domain.utils.ResponseResource
import com.axel.example.tienda.presetantion.components.progressBar
import com.axel.example.tienda.presetantion.navigation.Graph
import com.axel.example.tienda.presetantion.navigation.screen.AuthScreen
import com.axel.example.tienda.presetantion.views.auth.login.IniciarSesionViewModel


@Composable
fun Login( navController: NavController, vm:IniciarSesionViewModel = hiltViewModel()){
    when(val respuesta = vm.inicioRespuesta){
        ResponseResource.Loading ->{
            progressBar()
        }
         is ResponseResource.Success -> {
            LaunchedEffect(Unit){
                vm.guardarSesion(respuesta.data)
                if (respuesta.data.user?.roles?.size?:0 > 1){
                    navController.navigate(route = Graph.ROLES){
                        popUpTo(Graph.AUTH){
                            inclusive = true
                        }
                }

            }else{
                    navController.navigate(route = Graph.CLIENT){
                        popUpTo(Graph.AUTH){
                            inclusive = true
                        }
                    }
                }
            }
        }
         is ResponseResource.Failure -> {
            Toast.makeText(LocalContext.current,respuesta.mensajeError,Toast.LENGTH_SHORT).show()
        }
         else ->{
             if(respuesta != null  ){
                 Toast.makeText(LocalContext.current,"Error desconocido",Toast.LENGTH_SHORT).show()
             }
         }
    }

}