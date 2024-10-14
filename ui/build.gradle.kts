plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
    kotlin("android")
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.androidsdkdemo.ui"
    compileSdk = 34

    buildFeatures {
        compose = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}


dependencies {

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.core.ktx)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.coil.compose)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui.graphics)
}