package com.example.activitydemo

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class UtilsTest {

    private lateinit var utils: Utils

    @Before
    fun setUp() {
        // Arrange: Ініціалізація об'єкта перед кожним тестом
        utils = Utils()
    }

    @Test
    fun testIsEven_withEvenNumber_returnsTrue() {
        // Act
        val result = utils.isEven(4)
        // Assert
        assertTrue("Число 4 повинно бути парним", result)
    }

    @Test
    fun testIsEven_withOddNumber_returnsFalse() {
        // Act
        val result = utils.isEven(7)
        // Assert
        assertFalse("Число 7 не повинно бути парним", result)
    }

    @Test
    fun testIsEven_withZero_returnsTrue() {
        assertTrue("Нуль вважається парним числом", utils.isEven(0))
    }

    @Test
    fun testIsEven_withNegativeEvenNumber_returnsTrue() {
        assertTrue("-2 повинно бути парним", utils.isEven(-2))
    }

    @Test
    fun testStringToInt_withValidString_returnsInteger() {
        assertEquals(123, utils.stringToInt("123"))
    }

    @Test
    fun testStringToInt_withInvalidString_returnsNull() {
        assertNull("Для некоректного рядка має повернутися null", utils.stringToInt("abc"))
    }

    @Test
    fun testCalculateAverage_withMultipleNumbers_returnsCorrectAverage() {
        val numbers = listOf(10, 20, 30)
        val expected = 20.0
        assertEquals(expected, utils.calculateAverage(numbers), 0.001)
    }

    @Test
    fun testCalculateAverage_withEmptyList_returnsZero() {
        assertEquals(0.0, utils.calculateAverage(emptyList()), 0.001)
    }

    @Test
    fun testCalculateAverage_withSingleNumber_returnsThatNumber() {
        assertEquals(5.0, utils.calculateAverage(listOf(5)), 0.001)
    }
}
