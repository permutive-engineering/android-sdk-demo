plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
}

android {
    namespace = "com.example.androidsdkdemo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.androidsdkdemo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            buildConfigField("String", "WORKSPACE_ID", "\"YOUR_API_KEY\"")
            buildConfigField("String", "API_KEY", "\"YOUR_WORKSPACE_ID\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.ui)
    implementation(libs.hilt)
    implementation(libs.androidx.navigation.ui)
    debugImplementation(libs.permutive.debug)
    releaseImplementation(libs.permutive.core)
    implementation(project(":article-list"))
    implementation(project(":article"))
    kapt(libs.hiltCompiler)
    testImplementation(libs.junit)
}