package com.scrooge.foodtracker.data.amount

enum class AmountType(val baseUnit: AmountUnit) {
    Weight(AmountUnit.Gram),
    Volume(AmountUnit.Millilitre),
    Amount(AmountUnit.Piece),
}