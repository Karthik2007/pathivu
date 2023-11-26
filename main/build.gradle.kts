plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.kotlin.plugin.parcelize")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "main"
            // export(Dep.Decompose.core)
        }
    }

    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(Dep.Compose.ui)
                implementation(Dep.Compose.uiTooling)
                implementation(Dep.Compose.foundation)
                implementation(Dep.Compose.material)
                implementation(Dep.Compose.activity)
                implementation(Dep.Decompose.jetpackCompose)
            }
        }
        val commonMain by getting {
            dependencies {
                with(Dep.Koin) {
                    api(core)
                    api(test)
                }
                api(Dep.Decompose.core)
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.pathivu.main"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
}