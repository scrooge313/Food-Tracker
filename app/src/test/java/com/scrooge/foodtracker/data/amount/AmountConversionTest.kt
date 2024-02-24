package com.scrooge.foodtracker.data.amount

import org.junit.Test

import org.junit.Assert.*

class AmountConversionTest {
//    @Test
//    fun gramToKilogramConversion_constructorCallViaUnit_convertsCorrectly() {
//        val gramToKilogramConversion = AmountConversion(
//            fromUnit = AmountUnit.Gram,
//            toUnit = AmountUnit.Kilogram,
//            factor = 0.001,
//        )
//        validateGramToKilogramConversion(gramToKilogramConversion)
//    }
//
//    @Test
//    fun gramToLitreConversion_constructorCallViaUnit_convertsCorrectly() {
//        val gramToLitreConversion = AmountConversion(
//            fromUnit = AmountUnit.Gram,
//            toUnit = AmountUnit.Litre,
//            factor = 0.001,
//        )
//        validateGramToLitreConversion(gramToLitreConversion)
//    }
//
//    @Test
//    fun gramToKilogramConversion_constructorCallViaAmount_convertsCorrectly() {
//        val gramToKilogramConversion = AmountConversion(
//            fromAmount = 100.gram,
//            toAmount = Amount(0.1, AmountUnit.Kilogram)
//        )
//        validateGramToKilogramConversion(gramToKilogramConversion)
//    }
//
//    @Test
//    fun gramToLitreConversion_constructorCallViaAmount_convertsCorrectly() {
//        val gramToLitreConversion = AmountConversion(
//            fromAmount = 100.gram,
//            toAmount = Amount(0.1, AmountUnit.Litre)
//        )
//        validateGramToLitreConversion(gramToLitreConversion)
//    }
//
//    private fun validateGramToKilogramConversion(gramToKilogramConversion: AmountConversion) {
//        assertEquals(
//            gramToKilogramConversion.convert(1000.gram),
//            Amount(1.0, AmountUnit.Kilogram)
//        )
//        assertEquals(
//            gramToKilogramConversion.convert(1000.gram, AmountUnit.Gram),
//            1000.gram
//        )
//        assertThrows(IllegalArgumentException::class.java) {
//            gramToKilogramConversion.convert(
//                1000.gram,
//                AmountUnit.Millilitre
//            )
//        }
//        assertThrows(IllegalArgumentException::class.java) { gramToKilogramConversion.convert(1000.millilitre) }
//    }
//
//    private fun validateGramToLitreConversion(gramToLitreConversion: AmountConversion) {
//        assertEquals(
//            gramToLitreConversion.convert(1000.gram),
//            Amount(1.0, AmountUnit.Litre)
//        )
//        assertEquals(
//            gramToLitreConversion.convert(1000.gram, AmountUnit.Millilitre),
//            1000.millilitre
//        )
//        assertThrows(IllegalArgumentException::class.java) {
//            gramToLitreConversion.convert(
//                1000.gram,
//                AmountUnit.Gram
//            )
//        }
//        assertThrows(IllegalArgumentException::class.java) { gramToLitreConversion.convert(1000.millilitre) }
//    }

}