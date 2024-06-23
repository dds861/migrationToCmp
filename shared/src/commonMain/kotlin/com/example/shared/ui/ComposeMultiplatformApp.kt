package com.example.shared.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shared.MainViewModel
import com.example.shared.data.User
import org.koin.compose.koinInject

@Composable
fun App() {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            UserScreen()
        }
    }
}


@Composable
fun UserScreen(
    userViewModel: MainViewModel = koinInject(),
) {

    val articlesState = userViewModel.allUsers.collectAsState(initial = emptyList())
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                val userName = (1..10).map { ('a'..'z').random() }.joinToString("")
                userViewModel.insert(User(name = "$userName"))
            }) {
                Text(text = "Add User")
            }

            Button(onClick = {
                if (articlesState.value.isNotEmpty()) {
                    userViewModel.update(
                        User(
                            id = articlesState.value[0].id,
                            name = "Updated ${articlesState.value[0].name}"
                        )
                    )
                }
            }) {
                Text(text = "Update First User")
            }

            Button(onClick = {
                if (articlesState.value.isNotEmpty()) {
                    userViewModel.delete(articlesState.value[0])
                }
            }) {
                Text(text = "Delete First User")
            }

            Button(onClick = {
                userViewModel.deleteAll()
            }) {
                Text(text = "Delete All Users")
            }


            LazyColumn(modifier = Modifier.weight(1f)) {
                items(articlesState.value) { user ->
                    Text(text = user.name, style = MaterialTheme.typography.titleLarge)
                }
            }
        }
    }
}