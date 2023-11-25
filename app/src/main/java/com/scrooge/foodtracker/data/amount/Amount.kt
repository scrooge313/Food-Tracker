package com.scrooge.foodtracker.data.amount

data class Amount(
    val amountInUnit: Double,
    val unit: AmountUnit,
) {
    override fun toString() = "$amountInUnit ${unit.name.lowercase()}"
}

val Number.gram: Amount
    get() {
        return Amount(this.toDouble(), AmountUnit.Gram)
    }

val Number.millilitre: Amount
    get() {
        return Amount(this.toDouble(), AmountUnit.Millilitre)
    }

val Number.piece: Amount
    get() {
        return Amount(this.toDouble(), AmountUnit.Piece)
    }

val Number.kcal: Amount
    get() {
        return Amount(this.toDouble(), AmountUnit.Kcal)
    }
