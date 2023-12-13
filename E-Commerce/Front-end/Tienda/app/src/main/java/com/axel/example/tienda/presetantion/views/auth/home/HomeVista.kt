package com.axel.example.tienda.presetantion.views.auth.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeVista(navController: NavController){
    Scaffold() { paddingValue ->
        Text(   modifier= Modifier.padding(paddingValues = paddingValue ),
                text = "Pantalla de inicio")
    }
}