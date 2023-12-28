package com.axel.example.tienda.presetantion.views.auth.register
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.axel.example.tienda.presetantion.components.DefaultTopBar
import com.axel.example.tienda.presetantion.views.auth.register.components.Register
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
    Register(navController)
}