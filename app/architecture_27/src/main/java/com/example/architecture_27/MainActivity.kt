package com.example.architecture_27

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.architecture_27.ui.theme.AndroidBasicsKotlinCompose2026Theme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidBasicsKotlinCompose2026Theme {
                enableEdgeToEdge()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterViewWithVM(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CounterView(modifier: Modifier = Modifier) {
    val c = remember { mutableIntStateOf(0) }
    var count by remember { mutableIntStateOf(0) }

    Column(modifier = modifier) {
        Text("The Counter App")
        Row {
            Button(onClick = {
                c.intValue += 1
                count += 1
            }) {
                Text("Plus")
            }
            Button(onClick = {
                c.intValue -= 1
                count += 1
            }) {
                Text("Minus")
            }
        }
        Text("c = ${c.intValue} after $count clicks", fontSize = 42.sp)
    }
}

@Composable
fun CounterViewWithVM(modifier: Modifier = Modifier) {
    val viewModel: CounterViewModel = viewModel()
    val myUiState by viewModel.uiState.collectAsState()

    Column(modifier = modifier) {
        Text("The Counter App")
        Row {
            Button(onClick = {
                viewModel.counterChange(+1)
            }) {
                Text("Plus")
            }
            Button(onClick = {
                viewModel.counterChange(-1)
            }) {
                Text("Minus")
            }
        }
        Text("c = ${myUiState.c} after ${myUiState.count} clicks", fontSize = 42.sp)
    }
}

data class CounterUiState(val c: Int = 0, val count: Int = 0)

class CounterViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(CounterUiState())
    val uiState: StateFlow<CounterUiState> = _uiState.asStateFlow()

    fun counterChange(v: Int) {
        _uiState.value = CounterUiState(_uiState.value.c + v, _uiState.value.count + 1)
    }
}
