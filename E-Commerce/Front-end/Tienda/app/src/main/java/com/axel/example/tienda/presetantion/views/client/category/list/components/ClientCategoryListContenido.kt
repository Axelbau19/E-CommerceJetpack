package com.axel.example.tienda.presetantion.views.client.category.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ClientCategoryListContenido(paddingValues: PaddingValues){
    Text(modifier = Modifier.padding(paddingValues= paddingValues),
        text = "ClientCategoryView")
}