package com.scrooge.foodtracker.data.amount

// TODO unit test all of this thoroughly
data class AmountConversion(
    val fromUnit: AmountUnit,
    val toUnit: AmountUnit,
    val factor: Double,
) {
    constructor(
        fromAmount: Amount,
        toAmount: Amount,
    ) : this(fromAmount.unit, toAmount.unit, toAmount.amountInUnit / fromAmount.amountInUnit)

    val inversion: AmountConversion
        get() = AmountConversion(toUnit, fromUnit, 1 / factor)

    fun convert(amount: Amount, targetUnit: AmountUnit = toUnit): Amount {
        require(fromUnit.type == amount.unit.type)
        require(toUnit.type == targetUnit.type)
        return Amount(
            amount.amountInUnit *
            amount.unit.baseUnitMultiple / fromUnit.baseUnitMultiple *
            factor *
            toUnit.baseUnitMultiple / targetUnit.baseUnitMultiple,
            targetUnit
        )
    }
}
