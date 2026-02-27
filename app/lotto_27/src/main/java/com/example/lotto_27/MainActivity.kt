package com.example.lotto_27

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lotto_27.ui.theme.AndroidBasicsKotlinCompose2026Theme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBasicsKotlinCompose2026Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        LottoScreen(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

@Composable
fun LottoScreen(modifier: Modifier = Modifier) {

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            "Pick 7 numbers between 1 and 40",
            fontSize = 22.sp,
            modifier = Modifier
        )
        LottoControls()
        LottoPlay()
    }
}

@Composable
fun LottoPlay() {

    Button(onClick = {}) {
        Text(
            "Play",
            modifier = Modifier.padding(10.dp)
        )
    }

    Text(
        "Correct numbers: ",
        fontSize = 22.sp,
        modifier = Modifier.padding(top = 16.dp)
    )
}

@Composable
fun LottoControls(modifier: Modifier = Modifier) {

    val viewModel: LottoViewModel = viewModel()
    val myUiState by viewModel.uiState.collectAsState()

    val lottoNumbers = (1..40).toList()
    val pickedNumbers = (1..40).toList()

    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        items(lottoNumbers) { item ->
            Text(
                item.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}

data class LottoUiState(val c: Int = 0, val count: Int = 0)


class LottoViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LottoUiState())
    val uiState: StateFlow<LottoUiState> = _uiState.asStateFlow()


    fun pickedNumberChange(v: Int) {
        _uiState.value = LottoUiState(_uiState.value.c + v, _uiState.value.count + 1)
    }
}


@Preview(showBackground = true)
@Composable
fun LottoPreview() {
    AndroidBasicsKotlinCompose2026Theme {
        LottoScreen()
    }
}