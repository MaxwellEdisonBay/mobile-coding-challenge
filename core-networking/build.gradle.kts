import com.audiobooks.buildsrc.Configuration
import com.audiobooks.buildsrc.Dependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
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
        buildFeatures {
            buildConfig = true
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(
                "String",
                "PODCASTS_API_BASE_URL",
                "\"https://listen-api.listennotes.com/api/\""
            )
        }
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(
                "String",
                "PODCASTS_API_BASE_URL",
                "\"https://listen-api-test.listennotes.com/api/\""
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
}

dependencies {
    implementation(project(":core"))
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