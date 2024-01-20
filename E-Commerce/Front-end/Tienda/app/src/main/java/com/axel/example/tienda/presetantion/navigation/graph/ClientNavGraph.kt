package com.axel.example.tienda.presetantion.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.axel.example.tienda.presetantion.navigation.Graph
import com.axel.example.tienda.presetantion.navigation.screen.ClientScreen
import com.axel.example.tienda.presetantion.views.client.category.list.ClientCategoryListView
import com.axel.example.tienda.presetantion.views.client.products.list.ProductView
import com.axel.example.tienda.presetantion.views.profile.ProfileView

@Composable
fun  ClientNavGraph(navController: NavHostController){
    //Agregar una depedencia extra
    NavHost(
        navController= navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.ProductList.route
    ){
        composable(route=ClientScreen.ProductList.route){
            ProductView()
        }
        composable(route=ClientScreen.CategoryList.route){
            ClientCategoryListView()
        }
        composable(route=ClientScreen.Profile.route){
            ProfileView()
        }
    }
}