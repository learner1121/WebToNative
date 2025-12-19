package com.ourfy.webtonative.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ourfy.webtonative.userInterface.history.HistoryScreen
import com.ourfy.webtonative.userInterface.home.HomeScreen
import com.ourfy.webtonative.userInterface.webView.WebViewScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {

        composable(Routes.Home.route) {
            HomeScreen(navController)
        }

        composable(
            route = Routes.WebView.route,
            arguments = listOf(
                navArgument("url") { type = NavType.StringType }
            )
        ) {
            val url = it.arguments?.getString("url") ?: ""
           WebViewScreen(navController, url)
        }

        composable(Routes.History.route) {
            HistoryScreen(navController)
        }
    }
}
