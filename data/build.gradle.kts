plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
    kotlin("android")
}

android {
    namespace = "com.example.androidsdkdemo.data"
    compileSdk = 34

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.gson)
    implementation(libs.hilt)
    kapt(libs.hiltCompiler)
}