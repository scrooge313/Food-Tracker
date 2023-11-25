package com.scrooge.foodtracker.ui.ingredientssearchscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scrooge.foodtracker.data.recipe.Ingredient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class IngredientInfoViewModel(ingredientId: String) : ViewModel() { // TODO inject ingredient repository
    val _uiState = MutableStateFlow<Ingredient?>(null)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch { // TODO validate if this is proper usage
            _uiState.update {
                // TODO get ingredient by id
                null
            }
        }
    }
}