package com.scrooge.foodtracker.data.amount

enum class AmountType {
    Weight,
    Volume,
    Amount,
    Energy;

    val baseUnit: AmountUnit by lazy { AmountUnit.values().find { it.type == this && it.isBaseUnit }!!  }
}