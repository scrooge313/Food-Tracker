package com.scrooge.foodtracker.data

import com.scrooge.foodtracker.data.amount.AmountConversion
import com.scrooge.foodtracker.data.amount.gram
import com.scrooge.foodtracker.data.amount.piece
import com.scrooge.foodtracker.data.recipe.Ingredient

class LocalIngredientsDataSource {
    fun getAllIngredients(): List<Ingredient> {
        return listOf(
            Ingredient(
                name = "Garlic",
                alternativeNames = setOf("Knoblauch"),
                nutritionPerAmount = NutritionPerAmount(
                    1.piece,
                    Nutrition(
                        kcal = 4.5,
                        fatsInGrams = 0.0,
                        carbsInGrams = 0.0,
                        proteinsInGrams = 0.2,
                    )
                ),
                amountConversions = listOf(
                    AmountConversion(
                        1.piece, 3.gram
                    )
                ),
            )
        )
    }
}