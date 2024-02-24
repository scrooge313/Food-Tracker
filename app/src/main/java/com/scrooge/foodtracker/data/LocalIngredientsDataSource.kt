package com.scrooge.foodtracker.data

import com.scrooge.foodtracker.data.amount.AmountConversion
import com.scrooge.foodtracker.data.amount.g
import com.scrooge.foodtracker.data.amount.kcal
import com.scrooge.foodtracker.data.recipe.Ingredient
import java.util.UUID

class LocalIngredientsDataSource {
    fun getAllIngredients(): List<Ingredient> {
        return listOf(
//            Ingredient( TODO fix
//                id = UUID.randomUUID().toString(),
//                name = "Garlic",
//                alternativeNames = setOf("Knoblauch"),
//                nutritionPerAmount = NutritionPerAmount(
//                    1.piece,
//                    Nutrition(
//                        kcal = 4.5.kcal,
//                        fats = 0.0.g,
//                        carbs = 0.0.g,
//                        proteins = 0.2.g,
//                    )
//                ),
//                amountConversions = listOf(
//                    AmountConversion(
//                        1.piece, 3.g
//                    )
//                ),
//            ),
//            Ingredient(
//                id = UUID.randomUUID().toString(),
//                name = "Black Garlic",
//                alternativeNames = setOf("Schwarzer Knoblauch"),
//                nutritionPerAmount = NutritionPerAmount(
//                    1.piece,
//                    Nutrition(
//                        kcal = 4.5.kcal,
//                        fats = 0.0.gram,
//                        carbs = 0.0.gram,
//                        proteins = 0.2.gram,
//                    )
//                ),
//                amountConversions = listOf(
//                    AmountConversion(
//                        1.piece, 3.gram
//                    )
//                ),
//            ),
//            Ingredient(
//                id = UUID.randomUUID().toString(),
//                name = "Ginger",
//                alternativeNames = setOf("Ingwer"),
//                nutritionPerAmount = NutritionPerAmount(
//                    1.piece,
//                    Nutrition(
//                        kcal = 4.5.kcal,
//                        fats = 0.0.gram,
//                        carbs = 0.0.gram,
//                        proteins = 0.2.gram,
//                    )
//                ),
//                amountConversions = listOf(
//                    AmountConversion(
//                        1.piece, 3.gram
//                    )
//                ),
//            )
        )
    }
}