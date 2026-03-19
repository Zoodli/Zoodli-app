package com.zodli.app.presentation.home

data class HomeState(
    val isCountryMenuOpen: Boolean = false,
    val selectedCountryLabel: String = "No location selected",
    val countries: List<HomeCountry> = defaultCountries,
)

data class HomeCountry(
    val name: String,
    val flag: HomeFlag,
)

sealed interface HomeFlag {
    data object Japan : HomeFlag
    data object France : HomeFlag
    data object Mexico : HomeFlag
    data object Indonesia : HomeFlag
    data object Egypt : HomeFlag
}

val defaultCountries: List<HomeCountry> = listOf(
    HomeCountry(name = "Japan", flag = HomeFlag.Japan),
    HomeCountry(name = "France", flag = HomeFlag.France),
    HomeCountry(name = "Mexico", flag = HomeFlag.Mexico),
    HomeCountry(name = "Indonesia", flag = HomeFlag.Indonesia),
    HomeCountry(name = "Egypt", flag = HomeFlag.Egypt),
)
