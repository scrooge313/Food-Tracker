package com.scrooge.foodtracker.data.ingredients

import android.util.Log
import com.scrooge.foodtracker.data.amount.Amount
import com.scrooge.foodtracker.data.amount.Gram
import com.scrooge.foodtracker.data.amount.Kcal
import com.scrooge.foodtracker.data.amount.g
import com.scrooge.foodtracker.data.nutrition.Nutrition
import com.scrooge.foodtracker.data.nutrition.NutritionPerAmount
import gov.usda.fdc.model.AbridgedFoodNutrient
import javax.inject.Inject

class IngredientsRepository @Inject constructor(private val fdcDataSource: FdcDataSource) {
    suspend fun searchIngredients(searchTerms: String): List<SearchResultIngredient> {
        val cleanedSearchTerms = searchTerms
            .split(" ", ",", ";", ".")
            .map { it.trim() }
            .filter { it.isNotEmpty() }
        return cleanedSearchTerms.map { singleSearchTerm ->
            val singleSearchResult = fdcDataSource.searchIngredients(singleSearchTerm)
            singleSearchResult
                .map {
                    SearchResultIngredient(
                        source = IngredientSource.Fdc,
                        id = it.fdcId.toString(),
                        imageUrl = null,
                        name = it.description,
                        nutritionPerAmount = NutritionPerAmount(
                            amount = 100.g,
                            nutrition = parseNutrition(it.foodNutrients),
                        ),
                        debug = it.dataType
                    )
                }
        }
        .flatten().distinct()
    }

    private fun parseNutrition(nutrients: List<AbridgedFoodNutrient>?): Nutrition {
        return Nutrition(
            kcal = parseSingleNutrient(nutrients, "energy"),
            proteins = parseSingleNutrient(nutrients, "protein"),
            fats = parseSingleNutrient(nutrients, "Total lipid (fat)"),
            carbs = parseSingleNutrient(nutrients, "Carbohydrate, by difference"),
        )
    }

    private fun parseSingleNutrient(nutrients: List<AbridgedFoodNutrient>?, nutrientIdentifier: String): Amount? {
        val unitMapping = mapOf("g" to Gram, "kcal" to Kcal)
        val matchingNutrients = nutrients
            ?.filter {
                Log.d("unit", it.unitName.toString() + " + " + it.nutrientName.toString() + " + " + it.value)
                it.unitName?.lowercase() in unitMapping.keys &&
                        it.nutrientName?.lowercase() == nutrientIdentifier.lowercase()
            }
        if(matchingNutrients.isNullOrEmpty()) return null
        require(matchingNutrients.size == 1)
        val nutrient = matchingNutrients.first()
        if(nutrient.value == null) return null
        return Amount(nutrient.value.toDouble(), unitMapping.getValue(nutrient.unitName!!.lowercase()))
    }
}

enum class IngredientSource {
    OwnedRemote,
    Fdc,
}

data class SearchResultIngredient(
    val source: IngredientSource,
    val id: String,
    val imageUrl: String?,
    val name: String,
    val nutritionPerAmount: NutritionPerAmount,
    val debug: String?,
)