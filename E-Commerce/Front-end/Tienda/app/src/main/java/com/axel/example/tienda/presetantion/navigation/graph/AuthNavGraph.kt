package com.axel.example.tienda.presetantion.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.axel.example.tienda.presetantion.navigation.Graph
import com.axel.example.tienda.presetantion.navigation.screen.AuthScreen
import com.axel.example.tienda.presetantion.views.auth.home.HomeVista
import com.axel.example.tienda.presetantion.views.auth.login.iniciarSesionVista
import com.axel.example.tienda.presetantion.views.auth.register.RegistroUsuarioVista

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController){
    navigation(
        route=Graph.AUTH,
        startDestination = AuthScreen.Login.route

    ){
        composable(route=AuthScreen.Login.route){
            iniciarSesionVista(navController)
        }
        composable(route=AuthScreen.Register.route){
            RegistroUsuarioVista(navController)
        }
        composable(route=AuthScreen.Home.route){
            HomeVista(navController)
        }

    }
}
