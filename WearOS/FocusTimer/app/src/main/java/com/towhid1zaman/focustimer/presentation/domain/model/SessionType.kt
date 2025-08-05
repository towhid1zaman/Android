package com.towhid1zaman.focustimer.presentation.domain.model

enum class SessionType(val displayName: String, val durationMillis: Long) {
    POMODORO("Pomodoro", 25 * 60 * 1000),
    SHORT_BREAK("Short Break", 5 * 60 * 1000),
    LONG_BREAK("Long Break", 15 * 60 * 1000)
}