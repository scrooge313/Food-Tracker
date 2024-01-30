package com.scrooge.foodtracker.ui.ingredientssearchscreen

import androidx.lifecycle.ViewModel
import com.scrooge.foodtracker.data.LocalIngredientsDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class IngredientsSearchViewModel : ViewModel() {
    val _uiState = MutableStateFlow(IngredientsSearchUiState(emptyList()))
    val uiState = _uiState.asStateFlow()

    fun searchIngredients(searchTerm: String) {
        if(searchTerm.isNullOrBlank()) {
            _uiState.update {
                it.copy(
                    queriedIngredients = emptyList()
                )
            }
        } else {
            _uiState.update {
                it.copy(
                    queriedIngredients = LocalIngredientsDataSource().getAllIngredients()
                )
            }
        }
    }
}