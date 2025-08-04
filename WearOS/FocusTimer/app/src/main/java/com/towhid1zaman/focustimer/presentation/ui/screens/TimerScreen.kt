package com.towhid1zaman.focustimer.presentation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.towhid1zaman.focustimer.presentation.viewmodel.TimerViewModel
import java.util.concurrent.TimeUnit

@Composable
fun TimerScreen(viewModel: TimerViewModel = viewModel()) {
    val timerState by viewModel.timerState.collectAsState()

    val minutes = TimeUnit.MILLISECONDS.toMinutes(timerState.timeLeftMillis)
    val seconds = TimeUnit.MILLISECONDS.toSeconds(timerState.timeLeftMillis) % 60

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = String.format("%02d:%02d", minutes, seconds),
            style = MaterialTheme.typography.headlineLarge
        )

        // Adds vertical space between the timer and the buttons
        Spacer(modifier = Modifier.height(24.dp))

        Row {
            Button(onClick = { viewModel.startTimer() }, enabled = !timerState.isRunning) {
                Text("Start")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = { viewModel.pauseTimer() }, enabled = timerState.isRunning) {
                Text("Pause")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = { viewModel.resetTimer() }) {
                Text("Reset")
            }
        }
    }
}


/*
This is the UI layer in MVVM — the View.
It:
    Collects state from TimerViewModel
    Displays the timer value (MM:SS)
    Has buttons for Start / Pause / Reset

TimerScreen(...): This is the screen function, like an XML layout but in Kotlin.
viewModel() gives  a TimerViewModel instance, so we can access timer data and logic.


timerState is a StateFlow in the ViewModel.
    collectAsState() turns it into a Compose-friendly state.
    by means we automatically update the UI when timerState changes.
    So, whenever time ticks (every second), the UI will automatically recompose.

Column arranges items vertically.
    fillMaxSize() makes it take full screen.
    padding(16.dp) adds space around it.
    Arrangement.Center aligns children vertically center.
    Alignment.CenterHorizontally centers items horizontally.

Row {} puts buttons side by side
    Each Button() calls a ViewModel function
    enabled = decides if the button is clickable or not based on current state
        e.g. Don’t allow "Start" when already running

 */