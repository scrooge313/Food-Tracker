package com.scrooge.foodtracker.ui.ingredientssearchscreen

import androidx.lifecycle.ViewModel
import com.scrooge.foodtracker.data.LocalIngredientsDataSource
import com.scrooge.foodtracker.data.recipe.Ingredient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class IngredientInfoViewModel(ingredient: Ingredient) : ViewModel() {
    val _uiState = MutableStateFlow(ingredient)
    val uiState = _uiState.asStateFlow()
}