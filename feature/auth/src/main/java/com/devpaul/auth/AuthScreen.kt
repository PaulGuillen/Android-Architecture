package com.devpaul.auth

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.devpaul.auth.ui.theme.AndroidArchitectureTheme

@Composable
fun AuthScreen(navController: NavHostController) {
    Text(
        text = "Hello Test!",
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidArchitectureTheme {
        AuthScreen(navController = rememberNavController())
    }
}