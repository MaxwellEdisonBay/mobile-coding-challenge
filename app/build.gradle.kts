import com.audiobooks.buildsrc.Configuration
import com.audiobooks.buildsrc.Dependencies

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = Configuration.applicationId
    compileSdk = Configuration.compileSdk

    defaultConfig {
        applicationId = Configuration.applicationId
        minSdk = Configuration.minSdk
        targetSdk = Configuration.targetSdk
        versionCode = Configuration.versionCode
        versionName = Configuration.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.AndroidX.Core.coreKtx)
    implementation(Dependencies.AndroidX.Lifecycle.runtime)
    implementation(Dependencies.AndroidX.Activity.compose)
    implementation(platform(Dependencies.AndroidX.Compose.bom))
    implementation(Dependencies.AndroidX.Compose.ui)
    implementation(Dependencies.AndroidX.Compose.graphics)
    implementation(Dependencies.AndroidX.Compose.toolingPreview)
    implementation(Dependencies.AndroidX.Compose.material3)
    testImplementation(Dependencies.JUnit.junit4)
    androidTestImplementation(Dependencies.AndroidX.Test.extJunit)
    androidTestImplementation(Dependencies.AndroidX.Test.espresso)
    androidTestImplementation(platform(Dependencies.AndroidX.Compose.bom))
    androidTestImplementation(Dependencies.AndroidX.Compose.uiTest)
    debugImplementation(Dependencies.AndroidX.Compose.tooling)
    debugImplementation(Dependencies.AndroidX.Compose.uiTestManifest)
}