plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "com.androidsdkdemo.article"
    compileSdk = 34

    kotlinOptions {
        jvmTarget = "1.8"
    }

    defaultConfig {
        minSdk = 24
    }

    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.coil.compose)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.hilt)
    implementation(project(":ui"))
    implementation(project(":data"))
    implementation(project(":event-tracking"))
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.gson)
    debugImplementation(libs.androidx.ui.tooling)
    kapt(libs.hiltCompiler)
}