package com.scrooge.foodtracker.data.amount

data class Amount(
    val amountInUnit: Double,
    val unit: Unit,
) {
    private val formattedAmountInUnit: String = amountInUnit.toString()
        .dropLastWhile { it == '0' }
        .split(".")
        .let {
            listOf(it[0], if(it[1].length >= 2) it[1].substring(0, 2) else it[1])
        }
        .joinToString(".")
        .dropLastWhile { it == '.' }
    val label = "$formattedAmountInUnit ${unit.name.plural(amountInUnit).lowercase()}"
    val shortLabel = if(unit.shortName == unit.name) label else "$formattedAmountInUnit ${unit.shortName}"

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
