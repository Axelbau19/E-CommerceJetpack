package com.axel.example.tienda.presetantion.views.client.home.components
import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.axel.example.tienda.presetantion.navigation.screen.ClientScreen

@Composable
fun ClienBottomBar(navController: NavHostController){
    val screens = listOf(
        ClientScreen.ProductList,
        ClientScreen.CategoryList,
        ClientScreen.Profile
    )

    val navBackEntry by navController.currentBackStackEntryAsState()

    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screens.any{ it.route == currentDestination?.route}


    if(bottomBarDestination){
        BottomNavigation {
            screens.forEach{Screen ->
                ClientBottomBarItem(screen =Screen ,
                    currentDestination = currentDestination,
                    navController = navController )
            }
        }
    }

}