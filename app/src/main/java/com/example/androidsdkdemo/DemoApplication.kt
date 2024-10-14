package com.example.androidsdkdemo

import android.app.Application
import com.permutive.android.debug.PermutiveDebugLifecycleCallbacks
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class DemoApplication : Application() {

    @Inject
    lateinit var permutiveDebugLifecycleCallbacks: PermutiveDebugLifecycleCallbacks

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(permutiveDebugLifecycleCallbacks)
    }
}