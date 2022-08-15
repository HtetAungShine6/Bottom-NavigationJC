package com.example.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bottomnavigation.Screens.HomeScreen
import com.example.bottomnavigation.Screens.ReportingScreen
import com.example.bottomnavigation.Screens.SettingScreen

@Composable
fun BottomBarNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBar.Home.route
    ){
        composable(route = BottomBar.Home.route){
            HomeScreen()
        }
        composable(route = BottomBar.Reporting.route){
            ReportingScreen()
        }
        composable(route = BottomBar.Setting.route){
            SettingScreen()
        }
    }
}