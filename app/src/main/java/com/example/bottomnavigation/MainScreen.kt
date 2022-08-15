package com.example.bottomnavigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBarLayer(navController = navController)
        }
    ) {
        BottomBarNavGraph(navController = navController)
    }
}

@Composable
fun BottomBarLayer(navController: NavHostController){
    val screens = listOf(
        BottomBar.Reporting,
        BottomBar.Home,
        BottomBar.Setting
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        modifier = Modifier,
        backgroundColor = Color.Yellow
    ) {
        screens.forEach {
            screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen : BottomBar,
    currentDestination: NavDestination?,
    navController: NavHostController
){
    BottomNavigationItem(
        label = { Text(text = screen.title) },
        icon = {
               Icon(
                   imageVector = screen.icon,
                   contentDescription = "Navigation Icon"
               )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}