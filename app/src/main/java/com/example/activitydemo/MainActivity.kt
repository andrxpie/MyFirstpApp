package com.example.activitydemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                    ComposeScreen(modifier = Modifier.padding(innerPadding))
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
fun ComposeScreen(modifier: Modifier = Modifier) {
    // Стан для введення імені (TextField)
    var userName by remember { mutableStateOf("") }
    var greetingText by remember { mutableStateOf("Привіт! Введіть своє ім'я.") }

    // Стан для перемикання між трьома текстами
    val texts = listOf("Текст 1: Ласкаво просимо!", "Текст 2: Ви вивчили Compose!", "Текст 3: Декларативний UI - це круто!")
    var currentTextIndex by remember { mutableStateOf(0) }

    // Список для LazyColumn
    val itemsList = listOf("Елемент 1", "Елемент 2", "Елемент 3", "Елемент 4", "Елемент 5")

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Jetpack Compose Практика",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Інтерактивне вітання
        Text(text = greetingText, modifier = Modifier.padding(bottom = 8.dp))
        
        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text("Ваше ім'я") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { greetingText = "Привіт, $userName!" },
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text("Привітати")
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

        // Перемикання текстів
        Text(
            text = texts[currentTextIndex],
            modifier = Modifier
                .background(Color.LightGray)
                .padding(8.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { currentTextIndex = 0 }) { Text("1") }
            Button(onClick = { currentTextIndex = 1 }) { Text("2") }
            Button(onClick = { currentTextIndex = 2 }) { Text("3") }
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

        // Динамічний список
        Text(text = "Динамічний список:", fontWeight = FontWeight.Bold)
        LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(1f)
        ) {
            items(itemsList) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Text(text = item, modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}
