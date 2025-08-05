package com.towhid1zaman.focustimer.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.towhid1zaman.focustimer.presentation.viewmodel.TimerState

@Composable
fun TimerControls(
    timerState: TimerState,
    onStart: () -> Unit,
    onPause: () -> Unit,
    onReset: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Button(
                onClick = onStart,
                enabled = !timerState.isRunning
            ) {
                Text("Start")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = onPause,
                enabled = timerState.isRunning
            ) {
                Text("Pause")
            }
        }

        Button(
            modifier = Modifier
                .padding(bottom = 8.dp),
            onClick = onReset
        ) {
            Text("Reset")
        }
    }
}