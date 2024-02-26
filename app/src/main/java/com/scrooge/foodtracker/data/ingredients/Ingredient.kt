package com.scrooge.foodtracker.data.ingredients

import com.scrooge.foodtracker.data.nutrition.NutritionPerAmount
import com.scrooge.foodtracker.data.amount.AmountConversion

data class Ingredient(
    val id: String,
    val name: String,
    val alternativeNames: Set<String>,
    val nutritionPerAmount: NutritionPerAmount,
    val amountConversions: List<AmountConversion>,
    val imageUrl: String? = null,
    // TODO WIP val pieceSynonym: String? = null, // e.g. "clove", "slice"
) {
    init {
        require(!alternativeNames.contains(name))
        require(amountConversions.all {
            it.fromUnit.type != it.toUnit.type
        })
        require(amountConversions.all {
            it.fromUnit.type == nutritionPerAmount.amount.unit.type
        })
    }

    val searchNames: Set<String>
        get() = alternativeNames + name
}