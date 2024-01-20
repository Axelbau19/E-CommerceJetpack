package com.axel.example.tienda.presetantion.views.client.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.axel.example.tienda.presetantion.navigation.graph.ClientNavGraph
import com.axel.example.tienda.presetantion.views.client.home.components.ClienBottomBar
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientHomeVista(navController: NavHostController = rememberNavController()){
    Scaffold(
        bottomBar = { ClienBottomBar(navController = navController )}
    ) { paddingValue ->
        ClientNavGraph(navController = navController)
    }
}