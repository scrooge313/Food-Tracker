package com.scrooge.foodtracker.data.amount

// TODO unit test all of this thoroughly
data class AmountConversion(
    val fromUnit: Unit,
    val toUnit: Unit,
    val factor: Double,
) {
    constructor(
        fromAmount: Amount,
        toAmount: Amount,
    ) : this(fromAmount.unit, toAmount.unit, toAmount.amountInUnit / fromAmount.amountInUnit)

    val inversion: AmountConversion
        get() = AmountConversion(toUnit, fromUnit, 1 / factor)

    fun convert(amount: Amount, targetUnit: Unit = toUnit): Amount {
        require(fromUnit.type == amount.unit.type)
        require(toUnit.type == targetUnit.type)
        return Amount( // TODO multiple of base unit does no longer necessarily exist
            amount.amountInUnit *
//            amount.unit.multipleOfBaseUnit / fromUnit.multipleOfBaseUnit *
            factor * 1,
//            toUnit.multipleOfBaseUnit / targetUnit.multipleOfBaseUnit,
            targetUnit
        )
    }
}
