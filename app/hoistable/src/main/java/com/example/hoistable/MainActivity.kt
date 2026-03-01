package com.example.hoistable

import android.os.Bundle
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.hoistable.ui.theme.AndroidBasicsKotlinCompose2026Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBasicsKotlinCompose2026Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainView(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainView(modifier: Modifier = Modifier) {

    val howmany = 4
    var values: List<Int> by remember {
        mutableStateOf(List(howmany) { 0 })
    }

    Column(modifier = modifier) {
        Text("$values: ${values.sum()}", fontSize = 55.sp)
        (0..<howmany).forEach {
            ButtonView(index = it, values[it]) { i: Int ->
                val tmp = values.toMutableList()
                tmp[i]++
                values = tmp.toList()
            }
        }
    }
}

@Composable
fun ButtonView(index: Int, value: Int, onChange: (Int) -> Unit) {

    Row {
        Text("$value ", fontSize = 36.sp)

        Button(onClick = {
            onChange(index)
        }) {
            Text("Click!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidBasicsKotlinCompose2026Theme {
        MainView()
    }
}