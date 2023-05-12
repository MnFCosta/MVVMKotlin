package com.example.aprender.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aprender.R
import com.example.aprender.models.Task
import com.example.aprender.viewmodels.TasksViewModel

@Composable
fun TaskScreen(
    navController: NavController,
    tasksViewModel: TasksViewModel
) {
    taskList(tasks = listOf())
}

@Composable
fun taskList(tasks: List<Task>) {
    LazyColumn(){
        items(tasks){ task->
            TaskEntry(task = task, onCompletedChange = {})
        }
    }
}

@Composable
fun TaskEntry(
    task: Task,
    onCompletedChange: (Boolean) -> Unit
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp), elevation = 4.dp
    )
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row() {
                if (task.isImportant){
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_priority_high_24), contentDescription = "high priority")
                }
                Text(text = task.name)
            }
            Checkbox(checked = task.isCompleted, onCheckedChange = onCompletedChange)
        }
    }
}