# ⌚ Focus Timer - Wear OS App

A minimalist **Pomodoro-style Focus Timer** designed specifically for Wear OS smartwatches, built with **Jetpack Compose** and **MVVM architecture**.

---

## Features

- Start a 25-minute Pomodoro session directly from your watch
- View animated circular countdown timer
- Haptic feedback on session completion
- Built with clean MVVM architecture
- Fully built using **Jetpack Compose**
- Lightweight, fast, and distraction-free

=> What is Pomodoro-Style?
The Pomodoro Technique is a popular time management method that helps people stay focused and productive by breaking work into intervals:

The Classic Cycle:
    ✅ 25 minutes of focused work (1 Pomodoro)\
    ⏸️ 5 minutes break\
    🔁 Repeat 4 times → then take a 15-30 minute long break


You can think of it as a WearOS companion tool that helps you:\
    Stay focused while working\
    Take scheduled breaks\
    Use time wisely — without needing your phone

Core App Behavior\
    State	        Description\
    Idle	        Timer hasn’t started yet\
    Running	    Countdown is in progress (25 mins)\
    Paused	    User paused the timer\
    Finished	    Session complete – trigger haptic feedback

---
Features Completed So Far\
    1. Built from scratch with Jetpack Compose\
    2. Follows MVVM architecture\
    3. Fully working timer logic with ViewModel\
    4. Circular progress bar showing real-time progress\
    5. Start / Pause / Reset buttons\
    6. SessionType support (Focus, Short Break, Long Break)\
    7. Haptic feedback (vibration) on session completion\
    8. All UI components split into reusable Composable\
    9. Clean folder structure: ui, viewmodel, domain, util, etc.
---

## Tech Stack

| Layer       | Tech                            |
|------------|----------------------------------|
| UI         | Jetpack Compose for Wear OS      |
| Architecture | MVVM (Model-View-ViewModel)   |
| Language    | Kotlin                          |
| OS Target   | Wear OS (API 30+)               |

---

## Folder Structure

com.towhid1zaman.focustimer\
├── presentation\
│   ├── data\
│   ├── domain\
│   │   └── model           // TimerState, SessionType\
│   ├── ui\
│   │   ├── components      // CircularTimer, TimerControls, etc.\
│   │   └── screens         // TimerScreen.kt\
│   ├── util                // VibrationHelper.kt, TimeUtils.kt\
│   └── viewmodel           // TimerViewModel.kt


---
## Screenshots

Screenshots/Initial.PNG\
Screenshots/ButtonsWithSession.PNG\
Screenshots/CircularProgress.PNG\
Screenshots/LinearProgress.PNG

## ‍💻 Developed by

**Towhid Zaman**

