package id.co.mondo.suitmediatest.ui.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
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
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import id.co.mondo.suitmediatest.ui.Components.CardListUser
import id.co.mondo.suitmediatest.ui.theme.SuitMediaTestTheme
import id.co.mondo.suitmediatest.ui.viewmodels.ViewModels

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirdScreen(
    navController: NavController,
    viewModel: ViewModels = hiltViewModel(navController.getBackStackEntry("MainGraph"))
) {

    val isLoading = viewModel.isLoading
    val users = viewModel.users
    val isRefreshing = rememberSwipeRefreshState(isRefreshing = viewModel.isRefreshing)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Third Screen",
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
        SwipeRefresh(
            state = isRefreshing,
            onRefresh = {
                viewModel.fetchUsers()
            }
        ) {
            if (users.isEmpty() && !isLoading) {
                CircularProgressIndicator()
            } else if (users.isEmpty()) {
                Text(
                    text = "Tidak ada data pengguna",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(16.dp)
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp)
                        .fillMaxSize(),
                ) {
                    items(users) { user ->
                        CardListUser(
                            name = "${user.firstName} ${user.lastName}",
                            email = user.email,
                            image = user.avatar,
                            onClick = {
                                viewModel.nameUser = "${user.firstName} ${user.lastName}"
                                navController.navigate("SecondScreen")
                            }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
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