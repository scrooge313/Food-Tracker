package com.scrooge.foodtracker.ui.ingredientssearchscreen

import androidx.compose.foundation.clickable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IngredientInfoScreen(
    viewModel: IngredientInfoViewModel,
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val ingredient by viewModel.uiState.collectAsState()

    Scaffold(
        modifier = modifier,
    ) {

    }
}