package com.example.wednesday_25

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wednesday_25.ui.theme.AndroidBasicsKotlinCompose2026Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBasicsKotlinCompose2026Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val ints = listOf(1, 3, 4, 6, 9, 10)
                    InitListScreen(ints, modifier = Modifier.padding(innerPadding)) {
                        Log.i("JV", "Item $it clicked")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun InitListScreen(
    numbers: List<Int>,
    modifier: Modifier = Modifier,
    onItemClick: (Int) -> Unit) {
    LazyColumn(modifier = modifier) {
        item {
            Text("Eka item")
        }
        items(numbers) { n ->
            Text(n.toString(), modifier = Modifier
                .fillMaxSize()
                .clickable {onItemClick(n)}
                .padding(16.dp))
        }
        item {
            Text("Vika item")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidBasicsKotlinCompose2026Theme {
        Greeting("Android")
    }
}