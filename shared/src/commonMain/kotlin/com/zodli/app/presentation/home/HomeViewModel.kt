package com.zodli.app.presentation.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state

    fun onIntent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.CountryButtonClicked -> {
                _state.update { it.copy(isCountryMenuOpen = !it.isCountryMenuOpen) }
            }
            HomeIntent.CountryMenuDismissed -> {
                _state.update { it.copy(isCountryMenuOpen = false) }
            }
            is HomeIntent.CountrySelected -> {
                _state.update {
                    it.copy(
                        isCountryMenuOpen = false,
                        selectedCountryLabel = intent.country.name,
                    )
                }
            }
        }
    }
}
