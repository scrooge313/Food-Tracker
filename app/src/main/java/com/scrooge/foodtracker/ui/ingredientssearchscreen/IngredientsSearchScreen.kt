package com.scrooge.foodtracker.ui.ingredientssearchscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.scrooge.foodtracker.data.nutrition.NutritionPerAmount
import com.scrooge.foodtracker.data.amount.Amount
import com.scrooge.foodtracker.data.amount.g
import com.scrooge.foodtracker.data.amount.kcal
import com.scrooge.foodtracker.data.ingredients.IngredientSource
import com.scrooge.foodtracker.data.ingredients.SearchResultIngredient
import com.scrooge.foodtracker.data.nutrition.Nutrition
import com.scrooge.foodtracker.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IngredientsSearchScreen(
    onIngredientClick: (SearchResultIngredient) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: IngredientsSearchViewModel = hiltViewModel(), // todo check if hiltviewmodel or viewmodel should be used
) {
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            IngredientsSearchNavigationBar(
                onSearch = viewModel::searchIngredients,
                onAddButtonClick = { /*TODO*/ }
            )
        },
        modifier = modifier,
    ) { innerPadding ->
        IngredientsSearchResults(
            ingredients = uiState.queriedIngredients,
            onIngredientClick = onIngredientClick,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
fun IngredientsSearchNavigationBar(
    onSearch: (String) -> Unit,
    onAddButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        IngredientsSearchField(
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
fun IngredientAddButton(
    onClick: () -> Unit,
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.defaultMinSize(48.dp, 48.dp) // todo check min size
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Create ingredient")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IngredientsSearchField(
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
        leadingIcon = { /*TODO*/ }
    )
}

@Composable
fun IngredientsSearchResults(
    ingredients: List<SearchResultIngredient>,
    onIngredientClick: (SearchResultIngredient) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
    ) {
        items(ingredients) {
            IngredientSearchResultCard(
                ingredient = it,
                onClick = { onIngredientClick(it) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IngredientSearchResultCard(
    ingredient: SearchResultIngredient,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        onClick = onClick,
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            // TODO image
            Column {
                Text(
                    text = ingredient.name,
                    style = Typography.titleLarge,
                )
                MacroGrid(ingredient.nutritionPerAmount)
            }
        }
    }
}

@Composable
fun MacroGrid(
    nutritionPerAmount: NutritionPerAmount,
    modifier: Modifier = Modifier,
) {
    val borderRadius = 8.dp
    Box(
        modifier = modifier.background(
            Color.LightGray,
            RoundedCornerShape(borderRadius)
        )
    ) {
        Row(
            modifier = Modifier.padding(borderRadius)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Macro("Cals", nutritionPerAmount.nutrition.kcal)
                Macro("Proteins", nutritionPerAmount.nutrition.proteins)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Macro("Fats", nutritionPerAmount.nutrition.fats)
                Macro("Carbs", nutritionPerAmount.nutrition.carbs)
            }
        }
    }
}

@Composable
fun Macro(label: String, amountInGrams: Amount?, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text("${label}:")
        Text(amountInGrams?.shortLabel ?: "-")
    }
}

@Preview(showBackground = true)
@Composable
fun IngredientResultCard() {
    IngredientSearchResultCard(
        ingredient = SearchResultIngredient(
            source = IngredientSource.Fdc,
            id = "some-id",
            imageUrl = null,
            name = "Garlic",
            nutritionPerAmount = NutritionPerAmount(100.g, Nutrition(100.kcal, 20.g, 20.g, 32.135235232.g)),
            debug = "DEBUG STRING"
        ),
        onClick = { /*TODO*/ }
    )
}