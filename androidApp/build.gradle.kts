plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.pathivu.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.pathivu.android"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":main"))
    implementation(project(":domain_words"))
    implementation(Dep.Compose.ui)
    implementation(Dep.Compose.uiTooling)
    implementation(Dep.Compose.foundation)
    implementation(Dep.Compose.material)
    implementation(Dep.Compose.activity)
    implementation(Dep.Koin.core)
    implementation(Dep.Koin.android)
    implementation(Dep.Decompose.core)
    implementation(Dep.Decompose.jetpackCompose)
}