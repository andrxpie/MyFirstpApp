package com.example.activitydemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.activitydemo.ui.theme.ActivityDemoTheme

class MainActivity : ComponentActivity() {
    private val TAG = "MainActivityLifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")
        enableEdgeToEdge()
        setContent {
            ActivityDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ModifierDemoScreen(
                        onNavigate = {
                            val intent = Intent(this, SecondActivity::class.java)
                            startActivity(intent)
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }
}

@Composable
fun ModifierDemoScreen(onNavigate: () -> Unit, modifier: Modifier = Modifier) {
    var isClicked by remember { mutableStateOf(false) }
    var textFieldValue by remember { mutableStateOf("") }
    var displayValue by remember { mutableStateOf("Тут буде ваш текст") }
    var buttonClicked by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Вітаємо у додатку!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        // 1. Текст із закругленими кутами
        Text(
            text = "Текст із закругленими кутами",
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFBBDEFB))
                .padding(16.dp)
        )

        // 2. Поле вводу
        OutlinedTextField(
            value = textFieldValue,
            onValueChange = { textFieldValue = it },
            label = { Text("Введіть дані") },
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = displayValue,
            modifier = Modifier.testTag("resultText")
        )

        Button(
            onClick = { displayValue = textFieldValue },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Зберегти текст")
        }

        // 3. Кнопка зміни стану
        Button(
            onClick = { buttonClicked = !buttonClicked },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (buttonClicked) Color.Green else Color.Blue
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (buttonClicked) "Стан: Активно" else "Натисніть мене")
        }

        Button(
            onClick = onNavigate,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Перейти до другої Activity")
        }

        HorizontalDivider()

        // 4. Демонстрація клікабельного тексту
        Text(
            text = if (isClicked) "Мене натиснули!" else "Натисни на цей текст",
            modifier = Modifier
                .padding(8.dp)
                .clickable { isClicked = !isClicked }
                .background(if (isClicked) Color.Yellow else Color.Transparent)
                .padding(8.dp)
        )
    }
}
