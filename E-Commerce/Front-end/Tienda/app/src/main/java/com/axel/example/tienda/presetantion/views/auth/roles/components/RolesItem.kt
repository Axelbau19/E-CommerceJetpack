package com.axel.example.tienda.presetantion.views.auth.roles.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.axel.example.tienda.domain.model.Rol
import com.axel.example.tienda.presetantion.navigation.Graph
import com.axel.example.tienda.presetantion.navigation.screen.AuthScreen

@Composable
fun RolesItems(rol: Rol,navHostController: NavHostController){
    Column(modifier = Modifier.clickable {
        navHostController.navigate(route = rol.route ){
            popUpTo(route = Graph.ROLES){inclusive = true}
        }
    }) {
        Spacer(modifier = Modifier.height(20.dp) )
        AsyncImage(
                modifier = Modifier
                        .height(150.dp)
                        .width(150.dp),
                model = rol.image,
                contentDescription = null)
        Spacer(modifier = Modifier.height(10.dp) )
        Text(text = rol.name.uppercase(),
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp )
    }

}