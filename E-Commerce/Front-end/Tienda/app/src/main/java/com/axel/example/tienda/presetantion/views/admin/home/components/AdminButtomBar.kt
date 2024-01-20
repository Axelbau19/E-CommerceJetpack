package com.axel.example.tienda.presetantion.views.admin.home.components
import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.axel.example.tienda.presetantion.navigation.screen.AdminScreen


@Composable
fun AdminBottomBar(navController: NavHostController){
    val screens = listOf(
        AdminScreen.ProductList,
        AdminScreen.CategoryList,
        AdminScreen.Profile
    )

    val navBackEntry by navController.currentBackStackEntryAsState()

    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screens.any{ it.route == currentDestination?.route}


    if(bottomBarDestination){
        BottomNavigation {
            screens.forEach{Screen ->
                AdminBottomBarItem(screen =Screen ,
                    currentDestination = currentDestination,
                    navController = navController )
            }
        }
    }

}