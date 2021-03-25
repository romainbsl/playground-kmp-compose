plugins {
    id("org.jetbrains.compose") version "0.3.1"
    id("com.android.application")
    kotlin("android")
}

group = "org.kodein.playground"
version = "1.0"

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
    implementation("androidx.activity:activity-compose:1.3.0-alpha04")
    implementation("org.kodein.di:kodein-di-framework-android-core:7.4.0")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "org.kodein.playground.android"
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}