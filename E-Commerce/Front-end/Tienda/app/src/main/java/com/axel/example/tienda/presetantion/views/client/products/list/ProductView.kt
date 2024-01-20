package com.axel.example.tienda.presetantion.views.client.products.list

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.axel.example.tienda.presetantion.views.client.products.list.components.ProductsContenido
import com.axel.example.tienda.presetantion.views.profile.components.ProfileContenido

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductView(){
    Scaffold { paddingValues ->
        ProductsContenido(paddingValues = paddingValues )
    }
}