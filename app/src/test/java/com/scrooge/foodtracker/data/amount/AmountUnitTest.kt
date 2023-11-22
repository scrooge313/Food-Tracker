package com.scrooge.foodtracker.data.amount

import org.junit.Test

import org.junit.Assert.*

class AmountUnitTest {
    @Test
    fun amountTypeInitialization_isSuccessful() {
        assertEquals(
            AmountUnit.Gram.type,
            AmountType.Weight,
        )
        assertEquals(
            AmountUnit.Millilitre.type,
            AmountType.Volume,
        )
        assertEquals(
            AmountUnit.Piece.type,
            AmountType.Amount,
        )
    }
}