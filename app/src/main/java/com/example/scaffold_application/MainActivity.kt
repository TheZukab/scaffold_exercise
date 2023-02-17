package com.example.scaffold_application

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.scaffold_application.ui.theme.Scaffold_applicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold_applicationTheme {
                ScaffoldApp()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldApp() {
    Scaffold(
        topBar = { MyTopBar()},
        content = { Text(text = "Content for Home screen")},
        // bottomBar = { BottomAppBar { Text(text ="Bottom bar") }}
    )
}

@Composable
fun MyTopBar() {
    var expanded by remember { mutableStateOf(false) }
    TopAppBar(
        title = { Text("My app") },
        navigationIcon = {
            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(Icons.Filled.Menu, contentDescription = null)
            }
        },
        actions = {
            IconButton(
                onClick = {
                    expanded = !expanded
                }
            ) {
                Icon(Icons.Filled.MoreVert, contentDescription = null)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }) {
                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Text("Info")
                }
                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Text("Settings")
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Scaffold_applicationTheme {
    }
}