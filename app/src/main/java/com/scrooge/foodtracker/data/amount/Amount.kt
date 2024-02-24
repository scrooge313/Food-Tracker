package com.scrooge.foodtracker.data.amount

data class Amount(
    val amountInUnit: Double,
    val unit: Unit,
) {
    val label = "$amountInUnit ${unit.name.plural(amountInUnit).lowercase()}"
    val shortLabel = if(unit.shortName == unit.name) label else "$amountInUnit${unit.shortName}"

    override fun toString() = shortLabel
}

val Number.g: Amount
    get() {
        return Amount(this.toDouble(), Gram)
    }

val Number.mm: Amount
    get() {
        return Amount(this.toDouble(), Millilitre)
    }

val Number.kcal: Amount
    get() {
        return Amount(this.toDouble(), Kcal)
    }
