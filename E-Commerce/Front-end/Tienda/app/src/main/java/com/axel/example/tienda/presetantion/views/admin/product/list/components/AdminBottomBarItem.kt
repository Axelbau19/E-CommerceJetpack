package com.axel.example.tienda.presetantion.views.admin.product.list.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.axel.example.tienda.presetantion.navigation.screen.ClientScreen

@Composable
fun RowScope.AdminBottomBarItem(
    screen:ClientScreen,
    currentDestination:NavDestination?,
    navController: NavHostController
){
    BottomNavigationItem(
        label = {
            Text(text = screen.tittle)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription ="")
        },
        selected = currentDestination?.hierarchy?.any{
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(route = screen.route){
                popUpTo(navController.graph.findStartDestination().id)
            }
        }

    )
}