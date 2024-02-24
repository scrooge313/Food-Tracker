package com.scrooge.foodtracker.data.amount

enum class UnitType(val hasBaseUnit: Boolean = false) {
    Weight(true),
    Volume(true),
    Energy(true),
    Number,
}