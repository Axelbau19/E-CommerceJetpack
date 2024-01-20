package com.axel.example.tienda.presetantion.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.axel.example.tienda.presetantion.navigation.Graph
import com.axel.example.tienda.presetantion.navigation.screen.AdminScreen
import com.axel.example.tienda.presetantion.views.admin.category.list.AdminCategoryListView
import com.axel.example.tienda.presetantion.views.admin.product.list.AdminProductView
import com.axel.example.tienda.presetantion.views.profile.ProfileView

@Composable
fun  AdminNavGraph(navController: NavHostController){
    //Agregar una depedencia extra
    NavHost(
        navController= navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.ProductList.route
    ){
        composable(route=AdminScreen.ProductList.route){
            AdminProductView()
        }
        composable(route=AdminScreen.CategoryList.route){
            AdminCategoryListView()
        }
        composable(route=AdminScreen.Profile.route){
            ProfileView()
        }
    }
}