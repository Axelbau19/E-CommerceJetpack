package com.axel.example.tienda.presetantion.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.axel.example.tienda.presetantion.navigation.Graph

@Composable
fun  RootNavGraph(navController: NavHostController){
    //Agregar una depedencia extra
    NavHost(
        navController= navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ){
        AuthNavGraph(navController=navController)
    }
}