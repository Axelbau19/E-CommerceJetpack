package com.axel.example.tienda.presetantion.views.auth.roles

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.axel.example.tienda.presetantion.components.DefaultTopBar
import com.axel.example.tienda.presetantion.views.auth.roles.components.RolesContenido

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RolesView(navController: NavHostController){
    Scaffold(
            topBar = { DefaultTopBar(title = "Selecciona un rol")}
    ){paddingValue ->
        RolesContenido(paddingValue,navController)
    }
}