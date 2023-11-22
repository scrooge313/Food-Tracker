package com.scrooge.foodtracker.data

import com.scrooge.foodtracker.data.recipe.Ingredient

class IngredientsRepository(
    private val localDataSource: LocalIngredientsDataSource,
) {
    fun searchIngredients(searchTerm: String): List<Ingredient> {
        val searchTerms = searchTerm.split(" ", ",", ";", ".")
        val allIngredients = localDataSource.getAllIngredients()
        return allIngredients.filter { ingredient: Ingredient ->
            ingredient.names.any { name ->
                searchTerms.contains(name)
            }
        }
    }
}