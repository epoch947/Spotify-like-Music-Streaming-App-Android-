# Spotify-like Music Streaming App

A simplified music streaming application built with modern Android development practices and a Kotlin-based backend server.

## Project Structure

```
SpotifyApp/
├── Spotify/                 # Android Frontend
│   ├── app/
│   │   ├── src/main/java/com/laioffer/spotify/
│   │   │   ├── ui/          # UI Components (Compose)
│   │   │   ├── repository/  # Data Layer
│   │   │   ├── player/      # Media Playback
│   │   │   ├── network/     # API Communication
│   │   │   ├── database/    # Local Storage
│   │   │   └── datamodel/   # Data Models
│   │   └── build.gradle
└── spotify_backend/         # Kotlin Backend
    ├── src/main/kotlin/com/laioffer/
    │   └── Application.kt   # Ktor Server
    └── src/main/resources/
        ├── static/songs/    # Audio Files
        ├── feed.json        # Music Feed Data
        └── playlists.json   # Playlist Data
```

## Core Features

### Frontend (Android)
- **3 Main Screens**: Home, Favorites, and Playlists
- **Persistent Player Bar**: Continuous playback across screen navigation
- **Music Streaming**: Real-time audio playback with ExoPlayer
- **Local Caching**: Offline data persistence with Room Database
- **Modern UI**: Built with Jetpack Compose and Material Design principles

### Backend (Kotlin)
- **RESTful API**: 4 endpoints for music data and file serving
- **Static File Serving**: Audio file delivery for streaming
- **JSON Serialization**: Data exchange with Kotlinx Serialization
- **Content Negotiation**: Proper HTTP content type handling

## Technology Stack

### Frontend Technologies
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM (Model-View-ViewModel)
- **Dependency Injection**: Hilt
- **Networking**: Retrofit with JSON serialization
- **Local Database**: Room with Kotlin Coroutines
- **Media Playback**: ExoPlayer
- **Image Loading**: Coil
- **Navigation**: Jetpack Navigation Component

### Backend Technologies
- **Language**: Kotlin
- **Framework**: Ktor
- **Server**: Netty
- **Serialization**: Kotlinx Serialization
- **Content Types**: JSON and static file serving

## Key Implementation Details

### Architecture Pattern
The app follows MVVM architecture with clear separation of concerns:
- **UI Layer**: Compose screens and fragments
- **ViewModel Layer**: Business logic and state management
- **Repository Layer**: Data access abstraction
- **Data Layer**: Network APIs and local database

### Data Flow
1. UI components observe ViewModels
2. ViewModels interact with Repositories
3. Repositories manage data from multiple sources (API, Database)
4. ExoPlayer handles media streaming independently

### API Endpoints
- `GET /feed` - Music feed data
- `GET /playlists` - Available playlists
- `GET /playlist/{id}` - Specific playlist details
- `GET /songs/{filename}` - Audio file serving

## Getting Started

### Prerequisites
- Android Studio Arctic Fox or later
- Kotlin 1.8+
- JDK 11+

### Frontend Setup
1. Open `Spotify/` in Android Studio
2. Sync Gradle dependencies
3. Run the app on an emulator or device

### Backend Setup
1. Navigate to `spotify_backend/`
2. Run `./gradlew run` to start the server
3. Server will be available at `http://localhost:8080`

## Dependencies

### Frontend Dependencies
- Jetpack Compose 1.3.2
- Retrofit 2.9.0
- Room 2.4.3
- ExoPlayer 2.18.2
- Hilt 2.44
- Coil 2.2.2

### Backend Dependencies
- Ktor 2.2.4
- Kotlinx Serialization
- Netty Server
- Logback

## Development Highlights

- **Modern Android Development**: Uses latest Jetpack libraries and Compose
- **Clean Architecture**: Well-structured codebase with dependency injection
- **Full-Stack Experience**: Both frontend and backend implementation
- **Production-Ready Patterns**: Error handling, state management, and performance optimization
- **Scalable Design**: Modular architecture allowing easy feature additions


