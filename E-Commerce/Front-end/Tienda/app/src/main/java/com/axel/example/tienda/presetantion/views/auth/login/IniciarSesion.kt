package com.axel.example.tienda.presetantion.views.auth.login

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.axel.example.tienda.presetantion.views.auth.login.components.Login
import com.axel.example.tienda.presetantion.views.auth.login.components.iniciarSesion

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun iniciarSesionVista(navController: NavHostController){
    Scaffold {paddingValues ->
        iniciarSesion(navController=navController, paddingValues = paddingValues)
    }
    Login(navController = navController)
}

