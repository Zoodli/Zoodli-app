package com.zodli.app.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import zodli.shared.generated.resources.Res
import zodli.shared.generated.resources.eg
import zodli.shared.generated.resources.fr
import zodli.shared.generated.resources.id
import zodli.shared.generated.resources.jp
import zodli.shared.generated.resources.mx

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = remember { HomeViewModel() },
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
    ) {
        Text(
            state.selectedCountryLabel,
            style = TextStyle(fontSize = 20.sp),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
        )

        Row(modifier = Modifier.padding(start = 20.dp, top = 10.dp)) {
            DropdownMenu(
                expanded = state.isCountryMenuOpen,
                onDismissRequest = { viewModel.onIntent(HomeIntent.CountryMenuDismissed) },
            ) {
                state.countries.forEach { country ->
                    DropdownMenuItem(
                        text = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painter = painterResource(country.flag.toResource()),
                                    modifier = Modifier.size(50.dp).padding(end = 10.dp),
                                    contentDescription = "${country.name} flag",
                                )
                                Text(country.name, style = MaterialTheme.typography.bodyLarge)
                            }
                        },
                        onClick = { viewModel.onIntent(HomeIntent.CountrySelected(country)) },
                    )
                }
            }
        }

        Button(
            modifier = Modifier.padding(start = 20.dp, top = 10.dp),
            onClick = { viewModel.onIntent(HomeIntent.CountryButtonClicked) },
        ) {
            Text("Select Location")
        }
    }
}

private fun HomeFlag.toResource() = when (this) {
    HomeFlag.Japan -> Res.drawable.jp
    HomeFlag.France -> Res.drawable.fr
    HomeFlag.Mexico -> Res.drawable.mx
    HomeFlag.Indonesia -> Res.drawable.id
    HomeFlag.Egypt -> Res.drawable.eg
}
