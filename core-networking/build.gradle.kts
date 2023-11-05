import com.audiobooks.buildsrc.Dependencies
import com.audiobooks.buildsrc.Configuration
import com.audiobooks.buildsrc.Version

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.audiobooks.networking"
    compileSdk = Configuration.compileSdk

    defaultConfig {
        minSdk = Configuration.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Version.composeCompiler
    }
}

dependencies {
    with(Dependencies.AndroidX.Core) {
        implementation(coreKtx)
    }
    with(Dependencies.Google.DaggerHilt) {
        implementation(android)
        kapt(compiler)
    }
    with(Dependencies.SquareUp.Retrofit2) {
        implementation(retrofit)
        implementation(converterGson)
    }
    implementation(Dependencies.SquareUp.Okhhtp3.okhttp)
    kapt(Dependencies.AndroidX.Hilt.compiler)
    testImplementation(Dependencies.JUnit.junit4)
}