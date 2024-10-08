import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version "2.0.20"
    id("io.realm.kotlin") version "2.0.0"


}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            implementation(libs.koin.core)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.content.negotiation)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.ktor.serialization)
            implementation(libs.koin.test)
            implementation(libs.library.sync)


            // put your Multiplatform dependencies here
        }
        androidMain.dependencies {
            implementation(libs.ktor.client.cio)
            implementation(libs.firebase.firestore.ktx) // Agregar Firestore para Android.


        }

            iosMain.dependencies {
                implementation(libs.ktor.client.darwin)


                implementation(libs.kotlinx.coroutines.core.v160nativemt)  // Para soporte de corutinas en iOS
                    // Las dependencias de Firebase para iOS se manejarán a través de CocoaPods

            }

    }
    ios {
        compilations.getByName("main") {
            cinterops {
                val firestore by creating {
                    defFile("src/nativeInterop/cinterop/firestore.def")
                }
            }
        }
    }
}

android {
    namespace = "org.example.yugiohkmmtest.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
dependencies {
    implementation(libs.firebase.crashlytics.buildtools)
}
