import com.audiobooks.buildsrc.Configuration
import com.audiobooks.buildsrc.Dependencies
import com.audiobooks.buildsrc.Version

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
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
    packaging {
        resources.excludes.apply {
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }
}

dependencies {
    implementation(project(":core-ui"))
    implementation(project(":feature-podcasts"))
    implementation(project(":feature-about"))
    implementation(project(":feature-techstack"))

    with(Dependencies.AndroidX.Core) {
        implementation(coreKtx)
    }

    with(Dependencies.AndroidX.Lifecycle) {
        implementation(runtime)
    }

    with(Dependencies.AndroidX.Activity) {
        implementation(compose)
    }

    with(Dependencies.AndroidX.Compose) {
        implementation(platform(bom))
        implementation(ui)
        implementation(graphics)
        implementation(toolingPreview)
        implementation(material3)
        androidTestImplementation(platform(bom))
        androidTestImplementation(uiTest)
        debugImplementation(tooling)
        debugImplementation(uiTestManifest)
    }

    implementation(Dependencies.AndroidX.Navigation.compose)

    testImplementation(Dependencies.JUnit.junit4)

    with(Dependencies.AndroidX.Test) {
        androidTestImplementation(extJunit)
        androidTestImplementation(espresso)
    }

    with(Dependencies.Google.DaggerHilt) {
        implementation(android)
        kapt(compiler)
    }
}