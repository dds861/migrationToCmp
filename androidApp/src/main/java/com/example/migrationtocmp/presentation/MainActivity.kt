package com.example.migrationtocmp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.migrationtocmp.data.User
import com.example.migrationtocmp.presentation.ui.theme.MigrationToCmpTheme
import com.example.shared.Greeting
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MigrationToCmpTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val users by viewModel.allUsers.collectAsState(initial = emptyList())

                    UserScreen(
                        users = users,
                        insert = { viewModel.insert(it) },
                        update = { viewModel.update(it) },
                        delete = { viewModel.delete(it) },
                        deleteAll = { viewModel.deleteAll() }
                    )
                }
            }
        }
    }
}

@Composable
fun UserScreen(
    users: List<User>,
    insert: (User) -> Unit,
    update: (User) -> Unit,
    delete: (User) -> Unit,
    deleteAll: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                val userName = (1..10).map { ('a'..'z').random() }.joinToString("")
                insert(User(name = "${Greeting().greet()} $userName"))
            }) {
                Text(text = "Add User")
            }

            Button(onClick = {
                if (users.isNotEmpty()) {
                    update(User(id = users[0].id, name = "Updated ${users[0].name}"))
                }
            }) {
                Text(text = "Update First User")
            }

            Button(onClick = {
                if (users.isNotEmpty()) {
                    delete(users[0])
                }
            }) {
                Text(text = "Delete First User")
            }

            Button(onClick = { deleteAll() }) {
                Text(text = "Delete All Users")
            }


            LazyColumn(modifier = Modifier.weight(1f)) {
                items(users) { user ->
                    Text(text = user.name, style = MaterialTheme.typography.titleLarge)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MigrationToCmpTheme {
        UserScreen(
            users = listOf(User(name = "User 1"), User(name = "User 2")),
            insert = {},
            update = {},
            delete = {},
            deleteAll = {}
        )
    }
}