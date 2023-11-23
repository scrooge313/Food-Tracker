package com.scrooge.foodtracker.ui.ingredients

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.scrooge.foodtracker.data.NutritionPerAmount
import com.scrooge.foodtracker.data.recipe.Ingredient

@Composable
fun IngredientsSearchScreen() {
//    IngredientsSearchNavigationBar()
//    IngredientsSearchResults()
}

@Composable
fun IngredientsSearchNavigationBar(
    showBackButton: Boolean,
    onSearch: (String) -> Unit,
    onAddButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    onBackButtonClick: () -> Unit = { },
) {
    Row(modifier = modifier) {
        if(showBackButton) {
            BackButton(
                onClick = onBackButtonClick,
            )
        }
        IngredientsSearchBar(
            placeholder = "Find an ingredient",
            onSearchValueChanged = onSearch,
            modifier = Modifier.weight(1f),
        )
        IngredientAddButton(
            onClick = onAddButtonClick,
        )
    }
}

@Composable
fun BackButton(
    onClick: () -> Unit,
) {
    TODO("Not yet implemented")
}

@Composable
fun IngredientAddButton(
    onClick: () -> Unit,
) {
    TODO("Not yet implemented")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IngredientsSearchBar(
    placeholder: String,
    onSearchValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var searchTerm by remember {
        mutableStateOf("")
    }

    TextField(
        value = searchTerm,
        onValueChange = {
            searchTerm = it
            onSearchValueChanged(it)
        },
        placeholder = { Text(placeholder) },
        modifier = modifier,
        singleLine = true,
        leadingIcon = { TODO() }
    )
}

@Composable
fun IngredientsSearchResults(
    ingredients: List<Ingredient>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        items(ingredients) {
            IngredientSearchResultCard(
                ingredient = it,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun IngredientSearchResultCard(
    ingredient: Ingredient,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier) {
        Row {
            // TODO image
            Column {
                Text(ingredient.name)
                MacroGrid(ingredient.nutritionPerAmount)
            }
        }
    }
}

@Composable
fun MacroGrid(nutritionPerAmount: NutritionPerAmount) {
    Row {
        Column {

        }
        Column {

        }
    }
}
