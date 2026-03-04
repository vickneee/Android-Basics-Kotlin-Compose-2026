package com.example.wednesday_4_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp
                )
            ) {
                Surface(
                    modifier = Modifier.padding(it)
                ) {
                    PostScreen()
                }
            }
        }
    }
}

class MainViewModel : ViewModel() {

    var posts = mutableStateListOf<Post>()

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getPosts()
                posts.addAll(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<Post>
}

object RetrofitInstance {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}

@Composable
fun PostScreen(viewModel: MainViewModel = viewModel()) {

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(viewModel.posts) { post ->
            Text(
                text = post.title,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}