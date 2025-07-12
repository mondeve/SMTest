package id.co.mondo.suitmediatest

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.HiltAndroidApp
import id.co.mondo.suitmediatest.ui.screen.FirstScreen
import id.co.mondo.suitmediatest.ui.screen.SecondScreen

@Composable
fun SuitMediaNav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "FirstScreen") {
        composable("FirstScreen") {
            FirstScreen(navController)
        }
        composable("SecondScreen") {
            SecondScreen(navController)
        }

    }
}

@HiltAndroidApp
class SuitMediaApp : Application()