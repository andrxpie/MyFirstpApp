package com.example.activitydemo

class Utils {
    /**
     * Перевіряє, чи є число парним.
     */
    fun isEven(number: Int): Boolean {
        return number % 2 == 0
    }

    /**
     * Конвертує рядок у число. Повертає null, якщо рядок некоректний.
     */
    fun stringToInt(input: String): Int? {
        return input.toIntOrNull()
    }

    /**
     * Обчислює середнє значення списку чисел.
     * Повертає 0.0 для порожнього списку.
     */
    fun calculateAverage(numbers: List<Int>): Double {
        if (numbers.isEmpty()) return 0.0
        return numbers.sum().toDouble() / numbers.size
    }
}
