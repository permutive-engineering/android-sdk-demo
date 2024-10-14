package com.example.androidsdkdemo.di

import android.content.Context
import com.example.androidsdkdemo.BuildConfig
import com.permutive.android.Permutive
import com.permutive.android.debug.PermutiveDebugLifecycleCallbacks
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.UUID
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PermutiveModule {

    @Provides
    @Singleton
    fun providePermutive(@ApplicationContext context: Context): Permutive {
        return Permutive(
            context = context,
            workspaceId = UUID.fromString(BuildConfig.WORKSPACE_ID),
            apiKey = UUID.fromString(BuildConfig.API_KEY),
        )
    }

    @Provides
    @Singleton
    fun provideCallback(): PermutiveDebugLifecycleCallbacks {
        return PermutiveDebugLifecycleCallbacks()
    }
}