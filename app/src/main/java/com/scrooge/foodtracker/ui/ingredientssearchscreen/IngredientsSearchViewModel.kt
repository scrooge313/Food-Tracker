package com.scrooge.foodtracker.ui.ingredientssearchscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scrooge.foodtracker.data.ingredients.IngredientsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IngredientsSearchViewModel @Inject constructor(val ingredientsRepository: IngredientsRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(IngredientsSearchUiState(emptyList()))
    val uiState = _uiState.asStateFlow()

    fun searchIngredients(searchTerms: String) {
        if(searchTerms.isBlank()) {
            _uiState.update {
                it.copy(
                    queriedIngredients = emptyList()
                )
            }
        } else {
            viewModelScope.launch(Dispatchers.IO) {
                _uiState.update {
                    it.copy(
                        queriedIngredients = ingredientsRepository.searchIngredients(searchTerms)
                    )
                }
            }
        }
    }
}