package com.scrooge.foodtracker.ui.ingredientssearchscreen

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun IngredientInfoScreen(
    ingredientId: String,
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Text(text = ingredientId, modifier = Modifier.clickable { onBackButtonClick() })
}