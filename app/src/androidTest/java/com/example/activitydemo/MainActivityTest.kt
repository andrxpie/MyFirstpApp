package com.example.activitydemo

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testInitialTextIsDisplayed() {
        // 1. Перевірка, чи відображається початковий текст на головному екрані.
        composeTestRule.onNodeWithText("Вітаємо у додатку!").assertIsDisplayed()
    }

    @Test
    fun testButtonClickChangesState() {
        // 2. Тестування кнопки, яка змінює текст/стан.
        composeTestRule.onNodeWithText("Натисніть мене").assertIsDisplayed()
        composeTestRule.onNodeWithText("Натисніть мене").performClick()
        composeTestRule.onNodeWithText("Стан: Активно").assertIsDisplayed()
    }

    @Test
    fun testTextFieldInputAndSave() {
        // 3. Перевірка, чи поле вводу приймає текст і чи він зберігається після натискання кнопки.
        val testInput = "Привіт, Espresso!"
        
        // Знаходимо поле вводу за текстом мітки (label)
        composeTestRule.onNodeWithText("Введіть дані").performTextInput(testInput)
        
        // Натискаємо кнопку збереження
        composeTestRule.onNodeWithText("Зберегти текст").performClick()
        
        // Перевіряємо, чи з'явився текст у полі результату за допомогою testTag
        composeTestRule.onNodeWithTag("resultText").assertTextEquals(testInput).assertIsDisplayed()
    }

    @Test
    fun testNavigationToSecondActivity() {
        // 4. Тестування переходу між двома екранами.
        composeTestRule.onNodeWithText("Перейти до другої Activity").performClick()
        
        // Перевіряємо, чи відображається текст з другої Activity
        // Зауваження: В Compose тестах ми можемо перевіряти вузли, що з'явилися після переходу
        composeTestRule.onNodeWithText("Це друга Activity").assertIsDisplayed()
    }
}
