package com.scrooge.foodtracker.data.amount

enum class AmountType {
    Weight,
    Volume,
    Amount;

    val baseUnit: AmountUnit by lazy { AmountUnit.values().find { it.type == this && it.multipleOfBaseUnit == 1.0 }!!  }
}