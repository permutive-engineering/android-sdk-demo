package com.example.androidsdkdemo

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.permutive.android.Permutive
import com.permutive.android.debug.PermutiveDebugLifecycleCallbacks
import com.permutive.android.debug.enablePermutiveDebugOverlay
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var permutive: Permutive

    @Inject
    lateinit var permutiveDebugLifecycleCallbacks: PermutiveDebugLifecycleCallbacks

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            enablePermutiveDebugOverlay(
                callbacks = permutiveDebugLifecycleCallbacks,
                currentActivity = this,
                permutive = permutive
            )
        }
    }
}