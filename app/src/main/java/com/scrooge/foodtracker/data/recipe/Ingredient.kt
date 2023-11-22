package com.scrooge.foodtracker.data.recipe

import com.scrooge.foodtracker.data.NutritionPerAmount
import com.scrooge.foodtracker.data.amount.AmountConversion

data class Ingredient(
    val name: String,
    val searchNames: Set<String>,
    val nutritionPerAmount: NutritionPerAmount,
    val amountConversions: List<AmountConversion>,
) {
    init {
        require(!searchNames.contains(name))
        require(amountConversions.all {
            it.fromUnit.type != it.toUnit.type
        })
        require(amountConversions.all {
            it.fromUnit.type == nutritionPerAmount.amount.unit.type
        })
    }

    val names: Set<String>
        get() = searchNames + name
}
