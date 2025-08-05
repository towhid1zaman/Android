package com.towhid1zaman.focustimer.presentation.viewmodel

import com.towhid1zaman.focustimer.presentation.domain.model.SessionType

data class TimerState (
    val isRunning: Boolean =  false,
    val timeLeftMillis: Long = SessionType.POMODORO.durationMillis,
    val isFinished: Boolean = false,
    val isPaused: Boolean = false,
    val sessionType: SessionType = SessionType.POMODORO
)
/*
Property and Purpose for better understanding, will delete later :)

isRunning	        Whether the timer is actively counting,
timeLeftMillis	    Milliseconds left on the countdown,
totalTimeMillis	    Full time at the start (useful for percent progress),
isFinished	        True when countdown reaches 0,
isPaused	        Whether the user has paused the timer

TimerState is a data class that holds the current state of the timer screen-whether the timer is running, paused,
how much time is left, etc.

This state is used and managed by the ViewModel — and then observed by the UI.

In MVVM, the ViewModel is responsible for:

    Managing UI state
    Holding the logic needed to update the UI

So any data class that represents UI-related state, such as TimerState, naturally belongs to the viewmodel layer, because:

It’s produced by the ViewModel

    It’s consumed by the UI
    It’s not part of the domain/business logic (so not in domain/)
    And it’s not a model from a remote/local source (so not in data/)

 */