# Android To Display List Fetched from API

This Android application project demonstrates a simple implementation using Kotlin, Retrofit, and Jetpack Compose following MVVM architecture. The app fetches data from an API, filters it based on specific criteria, and displays the filtered list on the MainActivity screen using both Jetpack Compose and XML in KotlinXMLActivity.

## Features

- Fetches data from an API using Retrofit.
- MVVM architecture with ViewModel and Repository pattern.
- Displays a list filtered by listId and name (excluding blank or null names).
- Two implementations:
  - **MainActivity:** Uses Jetpack Compose for UI.
  - **KotlinXMLActivity:** Uses XML layout for UI.

## Technologies Used

- Kotlin
- Jetpack Compose
- Retrofit
- MVVM architecture
- Android XML layouts

## Structure

- **MainActivity:** Main screen using Jetpack Compose.
  - Composable functions for building UI components located in MainActivityComposable.kt.

- **KotlinXMLActivity:** Alternative screen using XML layout.
  - Uses RecyclerView and XML layout for UI.

- **ViewModels and Repository:**
  - MainViewModel.kt: Manages data and business logic.
  - MainRepository.kt: Handles data operations, including API calls.

- **Adapters:**
  - ListXMLAdapter.kt: Adapter for RecyclerView in KotlinXMLActivity.

## Installation

1. Clone the repository: git clone https://github.com/harshals25/FetchDisplayList
2. Open the project in Android Studio.
3. Build and run the project on an Android device or emulator.

## Usage
Once you build and run, initially MainActivity will run. If you want to run the KotlinXMLActivity, you can edit configurations in Android Studio and just run that activity. 
Explore the code to understand how Retrofit, MVVM architecture, and Jetpack Compose/XML are implemented, code is commented for more redability. 
