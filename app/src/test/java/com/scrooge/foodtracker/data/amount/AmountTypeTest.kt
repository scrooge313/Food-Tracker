package com.scrooge.foodtracker.data.amount

import org.junit.Test

import org.junit.Assert.assertEquals

class AmountTypeTest {
    @Test
    fun baseUnitComputation_isSuccessful() {
        assertEquals(
            AmountUnit.Gram,
            AmountType.Weight.baseUnit,
        )
        assertEquals(
            AmountUnit.Millilitre,
            AmountType.Volume.baseUnit,
        )
        assertEquals(
            AmountUnit.Piece,
            AmountType.Amount.baseUnit,
        )
    }
}