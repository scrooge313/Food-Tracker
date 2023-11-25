package com.scrooge.foodtracker.data.amount

// TODO separate multipleOfBaseUnit from base unit selection
enum class AmountUnit(
    val type: AmountType,
    val multipleOfBaseUnit: Double,
    val isBaseUnit: Boolean = false
) {
    Gram(AmountType.Weight, 1.0, true),
    Kilogram(AmountType.Weight, 1000.0),

    Millilitre(AmountType.Volume, 1.0, true),
    Litre(AmountType.Volume, 1000.0),
    LevelTablespoon(AmountType.Volume, 15.0),
    HeapedTablespoon(AmountType.Volume, 25.0),
    LevelTeaspoon(AmountType.Volume, 5.0),
    HeapedTeaspoon(AmountType.Volume, 7.0),

    Piece(AmountType.Amount, 1.0, true),

    Kcal(AmountType.Energy, 1.0, true);

    val baseUnit by lazy { this.type.baseUnit }
}