package com.scrooge.foodtracker.data.amount

open class Unit(
    val type: UnitType,
    val name: String,
    shortName: String?
) {
    val shortName = shortName ?: name
}

fun String.plural(amount: Double): String {
    if(amount == 1.0) return this
    if(this.endsWith("s")) return this
    if(this.endsWith("y")) return this.dropLast(1) + "ies"
    return this + "s"
}

open class UnitWithBaseUnit( // TODO test: all unit types with hasBaseUnit should use this class and vice versa
    unitType: UnitType,
    baseUnit: UnitWithBaseUnit?,
    multipleOfBaseUnit: Double,
    name: String,
    shortName: String?,
) : Unit(
    type = unitType,
    name = name,
    shortName = shortName,
) {
    init {
        require(unitType.hasBaseUnit)
    }

    val baseUnit = baseUnit ?: this
    val multipleOfBaseUnit = if(baseUnit == null) 1.0 else multipleOfBaseUnit
}

// energy
val Kcal = UnitWithBaseUnit(UnitType.Energy, null, 1.0, "calory", "kcal")

class WeightUnit(
    baseUnit: UnitWithBaseUnit?,
    multipleOfBaseUnit: Double,
    name: String,
    shortName: String?,
) : UnitWithBaseUnit(
    unitType = UnitType.Weight,
    baseUnit = baseUnit,
    multipleOfBaseUnit = multipleOfBaseUnit,
    name = name,
    shortName = shortName,
)

val Gram = WeightUnit(null, 1.0, "gram", "g")
val Kilogram = WeightUnit(Gram, 1000.0, "kilogram", "kg")

class VolumeUnit(
    baseUnit: UnitWithBaseUnit?,
    multipleOfBaseUnit: Double,
    name: String,
    shortName: String?,
) : UnitWithBaseUnit(
    unitType = UnitType.Volume,
    baseUnit = baseUnit,
    multipleOfBaseUnit = multipleOfBaseUnit,
    name = name,
    shortName = shortName,
)

val Millilitre = VolumeUnit(null, 1.0, "millilitre", "ml")
val Litre = VolumeUnit(Millilitre, 1000.0, "litre", "l")
val LevelTablespoon = VolumeUnit(Millilitre, 15.0, "level tablespoon", "tbsp")
val HeapedTablespoon = VolumeUnit(Millilitre, 25.0, "heaped tablespoon", "tbsp")
val LevelTeaspoon = VolumeUnit(Millilitre, 5.0, "level teaspoon", "tsp")
val HeapedTeaspoon = VolumeUnit(Millilitre, 7.0, "heaped teaspoon", "tsp")

// number units
class NumberUnit(
    name: String,
) : Unit(
    type = UnitType.Number,
    name = name,
    shortName = null,
)

val Piece = NumberUnit("piece") // TODO might be unused

val unitsByType = mapOf<UnitType, Set<Unit>>(
    UnitType.Energy to setOf(Kcal),
    UnitType.Weight to setOf(Gram, Kilogram),
    UnitType.Volume to setOf(Millilitre, Litre, LevelTablespoon, HeapedTablespoon, LevelTeaspoon, HeapedTeaspoon),
    UnitType.Number to setOf(Piece),
)

val baseUnitByType: Map<UnitType, UnitWithBaseUnit> =
    unitsByType.filterValues { it.isNotEmpty() && it.toList()[0] is UnitWithBaseUnit }.mapValues {
        (it.value.toList().first() as UnitWithBaseUnit).baseUnit
    }
