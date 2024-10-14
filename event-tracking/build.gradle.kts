plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
    kotlin("android")
}

android {
    namespace = "com.example.androidsdkdemo.eventTracking"
    compileSdk = 34

    kotlinOptions {
        jvmTarget = "1.8"
    }
}


dependencies {

    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.core.ktx)
    debugImplementation(libs.permutive.debug)
    releaseImplementation(libs.permutive.core)
    implementation(libs.hilt)
}