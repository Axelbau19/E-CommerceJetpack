package com.axel.example.tienda.presetantion.views.admin.category.list

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.axel.example.tienda.presetantion.views.admin.category.list.components.AdminCategoryListContenido
import com.axel.example.tienda.presetantion.views.client.category.list.components.ClientCategoryListContenido

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminCategoryListView(){
    Scaffold { paddingValues ->
       AdminCategoryListContenido(paddingValues = paddingValues )
    }
}