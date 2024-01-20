package com.axel.example.tienda.presetantion.views.admin.home

import android.annotation.SuppressLint

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.axel.example.tienda.presetantion.navigation.graph.AdminNavGraph
import com.axel.example.tienda.presetantion.views.admin.home.components.AdminBottomBar
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminHomeVista(navController: NavHostController = rememberNavController()){
    Scaffold(bottomBar ={ AdminBottomBar(navController = navController)} ) {  paddingValue ->
        AdminNavGraph(navController = navController)
    }
}