package com.scrooge.foodtracker.data

import com.scrooge.foodtracker.data.amount.Amount

data class NutritionPerAmount(
    val amount: Amount,
    val nutrition: Nutrition,
)
