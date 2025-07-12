package id.co.mondo.suitmediatest.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import id.co.mondo.suitmediatest.ui.theme.SuitMediaTestTheme

@Composable
fun FirstScreen() {

    Surface(

    ) {
        Column(

        ) {
Text("apa dle")
        }
    }

}


@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    SuitMediaTestTheme {
        FirstScreen()
    }
}