package com.scrooge.foodtracker.data.amount

import org.junit.Test

import org.junit.Assert.*

class UnitTest {
    @Test
    fun unitsByType_shouldBeInitializedCorrectly() {
        unitsByType.filterKeys { it != UnitType.Number }.forEach {
            val unitsForType = it.value
            assertTrue(unitsForType.isNotEmpty())
            val baseUnit = (unitsForType.toList()[0] as UnitWithBaseUnit).baseUnit
            assertEquals(it.key, baseUnit.type)
            assertTrue(unitsForType.contains(baseUnit))
            unitsForType.forEach { unit ->
                assertTrue(unit is UnitWithBaseUnit)
                assertEquals(baseUnit, (unit as UnitWithBaseUnit).baseUnit)
                if(unit == baseUnit) {
                    assertEquals(1.0, unit.multipleOfBaseUnit, 0.001)
                } else {
                    assertNotEquals(1.0, unit.multipleOfBaseUnit)
                }
            }
        }
        unitsByType.getValue(UnitType.Number).forEach {
            assertFalse(it is UnitWithBaseUnit)
        }
    }

    @Test
    fun baseUnitByType_shouldBeInitializedCorrectly() {
        assertEquals(setOf(UnitType.Energy, UnitType.Weight, UnitType.Volume), baseUnitByType.keys)
        assertEquals(Kcal, baseUnitByType.getValue(UnitType.Energy))
        assertEquals(Gram, baseUnitByType.getValue(UnitType.Weight))
        assertEquals(Millilitre, baseUnitByType.getValue(UnitType.Volume))
    }
}