package com.example.perjantai_13_2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.perjantai_13_2.ui.theme.AndroidBasicsKotlinCompose2026Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBasicsKotlinCompose2026Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var c by remember { mutableIntStateOf(0) }
    var d by rememberSaveable { mutableIntStateOf(100)}
    // var c = 0


    Log.d("XYZ", "Greeting(): c = $c, d = $d")

    c = d +99

    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

        Button({
            c++
            d++
            Log.d("XYZ", "onClick, $c, $d")
        }) {
            Text("Klick!")
        }
        // Text("c = $c, d = $d", fontSize = 62.sp)
        ViewValues(x = c, y = d)
    }
}

@Composable
fun ViewValues(x: Int, y: Int) {
    Log.d("XYZ", "ViewValues, $x, $y")
    Row {
        Text("x = $x", fontSize = 36.sp)
        Text(" y = $y", fontSize = 36.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidBasicsKotlinCompose2026Theme {
        Greeting("Android")
    }
}