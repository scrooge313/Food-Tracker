package com.scrooge.foodtracker.data

import com.scrooge.foodtracker.data.amount.Amount
import com.scrooge.foodtracker.data.amount.Kcal

data class Nutrition(
    val kcal: Amount?,
    val proteins: Amount?,
    val fats: Amount?,
    val carbs: Amount?,
) {
    init {
        require(kcal == null || kcal.unit == Kcal)
    }
}
