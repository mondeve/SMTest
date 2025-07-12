package id.co.mondo.suitmediatest.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import id.co.mondo.suitmediatest.R
import id.co.mondo.suitmediatest.ui.Components.CardListUser
import id.co.mondo.suitmediatest.ui.theme.SuitMediaTestTheme
import id.co.mondo.suitmediatest.ui.viewmodels.ViewModels

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirdScreen(
    navController: NavController,
    viewModel: ViewModels = hiltViewModel(navController.getBackStackEntry("MainGraph"))
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Second Screen",
                        style = MaterialTheme.typography.titleSmall
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                modifier = Modifier
                    .shadow(elevation = 2.dp),
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
                .fillMaxSize(),
        ) {
            val users = listOf(
                "John Doe" to "john.doe@example.com",
                "Jane Smith" to "jane.smith@example.com",
                "Alexander Hamilton" to "alex.ham@example.com"
            )

            for ((name, email) in users) {
                CardListUser(
                    name = name,
                    email = email,
                    image = R.drawable.logosuitmedia
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun ThirdScreenPreview() {
    SuitMediaTestTheme {
        val navController = rememberNavController()
        ThirdScreen(navController)
    }
}