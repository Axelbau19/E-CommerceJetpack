package com.axel.example.tienda.presetantion.views.admin.product.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AdminProductsContenido(paddingValues: PaddingValues){
    Text(modifier = Modifier.padding(paddingValues= paddingValues),
        text = "Products List View")
}