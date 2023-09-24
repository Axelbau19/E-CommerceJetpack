package com.axel.example.tienda.presetantion.views.auth.register

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.axel.example.tienda.presetantion.components.DefaultTopBar
import com.axel.example.tienda.presetantion.views.auth.login.components.iniciarSesion
import com.axel.example.tienda.presetantion.views.auth.register.components.RegistroContenido

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroUsuarioVista(navController: NavHostController){
    Scaffold(
        topBar = {
            DefaultTopBar(title = "Registro",
                upAvailabe = true,
                navController=navController)
        }
    ) {paddingValues ->
        RegistroContenido(paddingValues = paddingValues)
    }
}