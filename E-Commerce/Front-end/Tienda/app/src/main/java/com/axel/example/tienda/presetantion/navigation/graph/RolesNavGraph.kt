package com.axel.example.tienda.presetantion.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.axel.example.tienda.presetantion.navigation.Graph
import com.axel.example.tienda.presetantion.navigation.screen.AdminScreen
import com.axel.example.tienda.presetantion.navigation.screen.AuthScreen
import com.axel.example.tienda.presetantion.navigation.screen.RolesScreen
import com.axel.example.tienda.presetantion.views.admin.home.AdminHomeVista

import com.axel.example.tienda.presetantion.views.auth.roles.RolesView
import com.axel.example.tienda.presetantion.views.client.home.ClientHomeVista


fun NavGraphBuilder.RolesNavGraph(navController: NavHostController){
    navigation(
        route=Graph.ROLES,
        startDestination = RolesScreen.Roles.route

    ){
        composable(route=RolesScreen.Roles.route){
            RolesView(navController)
        }
        composable(route = Graph.CLIENT){
            ClientHomeVista()
        }
        composable(route = Graph.ADMIN){
           AdminHomeVista()
        }
    }
}
