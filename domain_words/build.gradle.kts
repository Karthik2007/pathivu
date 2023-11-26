plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "1.8.21"
    id("com.android.library")
    id("com.squareup.sqldelight")
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
            baseName = "domain_words"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                with(Dep.Koin) {
                    api(core)
                    api(test)
                }
                implementation(Dep.SqlDelight.runtime)
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Dep.SqlDelight.android)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(Dep.SqlDelight.native)
            }
        }
    }
}

android {
    namespace = "com.pathivu.domain_words"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
}

sqldelight {
    database("Words") {
        packageName = "com.pathivu.domain_words"
    }
}