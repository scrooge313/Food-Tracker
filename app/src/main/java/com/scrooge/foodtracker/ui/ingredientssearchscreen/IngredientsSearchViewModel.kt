package com.scrooge.foodtracker.ui.ingredientssearchscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scrooge.foodtracker.data.LocalIngredientsDataSource
import com.scrooge.foodtracker.data.datasources.FdcDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import gov.usda.fdc.model.SearchResultFood
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class IngredientsSearchViewModel @Inject constructor() : ViewModel() {
//class IngredientsSearchViewModel @Inject constructor(fdcDataSource: FdcDataSource) : ViewModel() {
    val _uiState = MutableStateFlow(IngredientsSearchUiState(emptyList()))
    val uiState = _uiState.asStateFlow()

    val _otherState = MutableStateFlow(emptyList<SearchResultFood>())
    val otherState = _otherState.asStateFlow()

//    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            _otherState.emit(
//                fdcDataSource.searchIngredients("garlic")
//            )
//        }
//    }

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