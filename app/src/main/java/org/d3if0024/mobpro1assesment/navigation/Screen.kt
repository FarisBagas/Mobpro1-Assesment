package org.d3if0024.mobpro1assesment.navigation

sealed class Screen (val route: String){
    data object Home: Screen("mainScreen")
}