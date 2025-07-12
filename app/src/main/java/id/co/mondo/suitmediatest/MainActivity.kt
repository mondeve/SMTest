package id.co.mondo.suitmediatest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import id.co.mondo.suitmediatest.ui.screen.FirstScreen
import id.co.mondo.suitmediatest.ui.theme.SuitMediaTestTheme
import id.co.mondo.suitmediatest.ui.viewmodels.SplashScreenViewModel

class MainActivity : ComponentActivity() {

    private val viewModel:SplashScreenViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        splashScreen.setKeepOnScreenCondition {
            viewModel.isLoading.value
        }

        setContent {
            SuitMediaTestTheme {
                FirstScreen()
            }
        }
    }
}