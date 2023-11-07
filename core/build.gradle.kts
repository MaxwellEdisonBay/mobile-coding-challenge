import com.audiobooks.buildsrc.Configuration
import com.audiobooks.buildsrc.Dependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.audiobooks.core"
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
    with(Dependencies.AndroidX.Core) {
        implementation(coreKtx)
    }
    testImplementation(Dependencies.JUnit.junit4)
}