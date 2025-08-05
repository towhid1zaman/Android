package com.towhid1zaman.focustimer.presentation.ui.screens

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.towhid1zaman.focustimer.presentation.domain.model.SessionType
import com.towhid1zaman.focustimer.presentation.viewmodel.TimerViewModel
import java.util.concurrent.TimeUnit
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

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
        SessionTypeSelector(
         selectedSession = timerState.sessionType,
            onSessionSelected = {
                session ->
                viewModel.setSession(session)
            }
        )

        Text(
            text = String.format("%02d:%02d", minutes, seconds),
            style = MaterialTheme.typography.headlineMedium
        )

        // Adds vertical space between the timer and the buttons
        //Spacer(modifier = Modifier.height(8.dp))

        Row {
            val context = LocalContext.current
            Button(
                onClick = {
                    viewModel.startTimer {
                        // Vibrate on finish
                        val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                            val manager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                            manager.defaultVibrator
                        } else {
                            @Suppress("DEPRECATION")
                            context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                        }
                        Log.d("TIMER", "Vibration should happen now!")
                        vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
                    }
                },
                enabled = !timerState.isRunning
            ) {
                Text("Start")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = { viewModel.pauseTimer() }, enabled = timerState.isRunning) {
                Text("Pause")
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier = Modifier
                    .padding(bottom = 8.dp),
                onClick = { viewModel.resetTimer() }
            ) {
                Text("Reset")
            }
        }
    }
}

@Composable
fun SessionTypeSelector(
    selectedSession: SessionType,
    onSessionSelected: (SessionType) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp, start = 5.dp, end = 5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        SessionType.entries.forEach { session ->
            Button(
                onClick = { onSessionSelected(session) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (session == selectedSession) Color.Green else Color.Gray
                ),
                modifier = Modifier
                    .height(40.dp)
                    .weight(1f)
                    .padding(horizontal = 2.dp)
            ) {
                Text(text = session.displayName, fontSize = 12.sp)
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