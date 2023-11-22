package com.scrooge.foodtracker.data.amount

data class Amount(
    val amountInUnit: Double,
    val unit: AmountUnit,
)

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