package com.scrooge.foodtracker.data.amount

enum class AmountUnit(val type: AmountType, val baseUnitMultiple: Double) {
    Gram(AmountType.Weight, 1.0),
    Kilogram(AmountType.Weight, 1000.0),

    Millilitre(AmountType.Volume, 1.0),
    Litre(AmountType.Volume, 1000.0),
    LevelTablespoon(AmountType.Volume, 15.0),
    HeapedTablespoon(AmountType.Volume, 25.0),
    LevelTeaspoon(AmountType.Volume, 5.0),
    HeapedTeaspoon(AmountType.Volume, 7.0),

    Piece(AmountType.Amount, 1.0);

    val toBaseUnitConversion: AmountConversion = AmountConversion(type.baseUnit, this, baseUnitMultiple)
    val fromBaseUnitConversion: AmountConversion = toBaseUnitConversion.inversion
}