package com.axel.example.tienda.presetantion.navigation.screen

sealed class AuthScreen(val route:String){
    object Login: AuthScreen("login")
    object Register: AuthScreen("register")
    object Home : AuthScreen("home")
    object Roles: AuthScreen("roles")
}
