package com.devpaul.auth.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.devpaul.auth.ui.theme.AndroidArchitectureTheme
import com.devpaul.navigation.MainGraph

@Composable
fun AuthScreen(args: MainGraph.AuthArgs) {
    Text(
        text = "Hello Test!",
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidArchitectureTheme {
        AuthScreen(MainGraph.AuthArgs("",""))
    }
}