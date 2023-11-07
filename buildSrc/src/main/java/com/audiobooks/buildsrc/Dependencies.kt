package com.audiobooks.buildsrc

object Dependencies {
    object AndroidX {
        object Core {
            const val coreKtx = "androidx.core:core-ktx:${Version.androidCore}"
        }

        object Activity {
            const val compose = "androidx.activity:activity-compose:1.7.2"
        }

        object Lifecycle {
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
        }

        object Compose {
            const val bom = "androidx.compose:compose-bom:${Version.compose}"
            const val ui = "androidx.compose.ui:ui"
            const val uiTest = "androidx.compose.ui:ui-test-junit4"
            const val uiTestManifest = "androidx.compose.ui:ui-test-manifest"
            const val graphics = "androidx.compose.ui:ui-graphics"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview"
            const val tooling = "androidx.compose.ui:ui-tooling"
            const val material3 = "androidx.compose.material3:material3"
        }

        object Navigation {
            const val compose =
                "androidx.navigation:navigation-compose:${Version.navigationCompose}"
        }

        object Hilt {
            const val navigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"
            const val compiler = "androidx.hilt:hilt-compiler:1.0.0"
        }

        object Test {
            const val extJunit = "androidx.test.ext:junit:1.1.5"
            const val espresso = "androidx.test.espresso:espresso-core:3.5.1"
            const val core = "androidx.test:core:1.5.0"
        }
    }

    object Google {
        object DaggerHilt {
            const val android = "com.google.dagger:hilt-android:${Version.hilt}"
            const val compiler = "com.google.dagger:hilt-android-compiler:${Version.hilt}"
        }
    }

    object JUnit {
        const val junit4 = "junit:junit:4.13.2"
    }

    object Io {
        object Coil {
            const val coilCompose = "io.coil-kt:coil-compose:2.5.0"
        }

        object Mockk {
            const val mockk = "io.mockk:mockk:1.13.4"
        }
    }

    object SquareUp {
        object Okhhtp3 {
            const val okhttp = "com.squareup.okhttp3:okhttp:5.0.0-alpha.2"
        }

        object Retrofit2 {
            const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
            const val converterGson = "com.squareup.retrofit2:converter-gson:2.9.0"
        }
    }

    object Org {
        object JetBrains {
            object KotlinX {
                const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"
            }
        }
    }
}