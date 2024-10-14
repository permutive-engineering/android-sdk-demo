plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "com.androidsdkdemo.articles.list"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    testOptions {
        targetSdk = 34
    }

    kotlinOptions {
        jvmTarget = "1.8"
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
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.hilt)
    implementation(project(":data"))
    implementation(project(":ui"))
    implementation(project(":article"))
    implementation(project(":event-tracking"))
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.gson)
    debugImplementation(libs.androidx.ui.tooling)
    kapt(libs.hiltCompiler)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    debugImplementation(libs.androidx.fragment.testing)
    debugImplementation(libs.androidx.fragment.ktx)
    debugImplementation(libs.androidx.core)
    debugImplementation(libs.androidx.rules)
    debugImplementation(libs.androidx.runner)
    debugImplementation(libs.ui.test.manifest)
    kapt(libs.hiltCompiler)
}