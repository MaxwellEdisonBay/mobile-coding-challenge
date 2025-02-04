import com.audiobooks.buildsrc.Dependencies
import com.audiobooks.buildsrc.Configuration

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.audiobooks.feature_techstack"
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
        kotlinCompilerExtensionVersion = com.audiobooks.buildsrc.Version.composeCompiler
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":core-ui"))
    with(Dependencies.AndroidX.Core) {
        implementation(coreKtx)
    }
    with(Dependencies.AndroidX.Lifecycle) {
        implementation(runtime)
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
}