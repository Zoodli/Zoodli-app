package com.zodli.app

import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zodli.app.presentation.home.HomeScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        Surface(modifier = Modifier.safeContentPadding()) {
            HomeScreen()
        }
    }
}
