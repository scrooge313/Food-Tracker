package com.scrooge.foodtracker.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.scrooge.foodtracker.ui.ingredientssearchscreen.IngredientInfoScreen
import com.scrooge.foodtracker.ui.ingredientssearchscreen.IngredientInfoViewModel
import com.scrooge.foodtracker.ui.ingredientssearchscreen.IngredientsSearchScreen

@Composable
fun FoodTrackerApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
) {
    fun navigateBackButton() {
        navController.popBackStack()
    }

    NavHost(
        navController = navController,
        startDestination = "ingredients",
    ){
        composable("ingredients") {
            IngredientsSearchScreen(
                onIngredientClick = {
                    navController.navigate("ingredients/${it.id}")
                },
                modifier = modifier,
            )
        }
        composable("ingredients/{ingredientId}") {
            val ingredientId = it.arguments!!.getString("ingredientId")!!
            IngredientInfoScreen(
                viewModel = IngredientInfoViewModel(ingredientId),
                onBackButtonClick = ::navigateBackButton,
                modifier = modifier,
            )
        }
    }
}