package com.example.aprender.views

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aprender.R
import com.example.aprender.viewmodels.TasksViewModel

@Composable
fun MainScreen(
    tasksViewModel: TasksViewModel = viewModel()
) {
    val navController = rememberNavController()
    
    Scaffold(
        topBar = {
            TopAppBar() {
                Text(text="My App")
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.ic_baseline_add_24), contentDescription = null)
            }
        }

    ) {
        NavHost(navController = navController, startDestination = "insert_edit_task" ){
            composable("task_list"){
                TaskScreen(navController = navController, tasksViewModel = tasksViewModel)
            }
            composable("insert_edit_task"){
                InsertEditTaskScreen(navController = navController, tasksViewModel = tasksViewModel)
            }
        }
    }
}