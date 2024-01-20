package com.axel.example.tienda.presetantion.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.axel.example.tienda.presetantion.navigation.Graph
import com.axel.example.tienda.presetantion.views.client.home.ClientHomeVista

@Composable
fun  RootNavGraph(navController: NavHostController){
    //Agregar una depedencia extra
    NavHost(
        navController= navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ){
        AuthNavGraph(navController=navController)
        RolesNavGraph(navController=navController)

    }
}