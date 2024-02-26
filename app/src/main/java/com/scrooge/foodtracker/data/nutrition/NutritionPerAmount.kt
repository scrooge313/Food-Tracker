package com.scrooge.foodtracker.data.nutrition

import com.scrooge.foodtracker.data.amount.Amount
import com.scrooge.foodtracker.data.amount.UnitType

data class NutritionPerAmount(
    val amount: Amount,
    val nutrition: Nutrition,
) {
    init {
        require(amount.unit.type in setOf(UnitType.Weight, UnitType.Volume))
    }
}
