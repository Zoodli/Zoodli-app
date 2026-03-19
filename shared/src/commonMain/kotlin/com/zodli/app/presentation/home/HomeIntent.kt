package com.zodli.app.presentation.home

sealed interface HomeIntent {
    data object CountryButtonClicked : HomeIntent
    data object CountryMenuDismissed : HomeIntent
    data class CountrySelected(val country: HomeCountry) : HomeIntent
}
