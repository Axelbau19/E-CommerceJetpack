package com.axel.example.tienda.presetantion.views.admin.product.list

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.axel.example.tienda.presetantion.views.admin.product.list.components.AdminProductsContenido
import com.axel.example.tienda.presetantion.views.client.products.list.components.ProductsContenido

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminProductView(){
    Scaffold { paddingValues ->
        AdminProductsContenido(paddingValues = paddingValues )
    }
}