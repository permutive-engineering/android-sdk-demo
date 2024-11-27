# android-sdk-demo

This project serves as an example for integrating the Permutive Android SDK. It consists of two simple screens, one containing a list of articles and a second screen with a full article. We use this demo app to send events to Permutive which will in turn generate user cohorts. The data is currently hardcoded and read from a local JSON file.

![Screenshot_20241105_115642](https://github.com/user-attachments/assets/7c0e3b4b-ea46-4c0a-a333-54d0894a8356)
![Screenshot_20241105_115657](https://github.com/user-attachments/assets/500ee5c2-b84b-42e4-ad01-ae4f997fa1cd)

## Adding the Permutive SDK

We add `com.permutive.android:core:1.9.5` as a `releaseImplementation` to the relevant feature build.gradle files. Please check https://developer.permutive.com/docs/android for the latest stable version (please note that the developer docs require authentication). 

## Creating a Permutive instance 

We instantiate a singleton `permutive` object in a `PermutiveModule` in a dedicated feature module. We can then use the same instance across the application lifecycle. We used Hilt here for dependency injection (DI) but the same can be achieved with other DI frameworks or by manually providing an instance in the Application class. You will need to pass the applicationContext to the `Permutive` constructor as well as the `WORKSPACE_ID` and `API_KEY` in order for the SDK to work.

```kotlin
@Provides
    @Singleton
    fun providePermutive(@ApplicationContext context: Context): Permutive {
        return Permutive(
            context = context,
            workspaceId = UUID.fromString(BuildConfig.WORKSPACE_ID),
            apiKey = UUID.fromString(BuildConfig.API_KEY),
        )
    }
```

## Calling the Permutive API

The `EventTrackerUseCase` calls the API's `trackPage` and `updatePercentageViewed` methods. 

## Checking the events

We're using the optional `DebugOverlay` to check what events have been tracked and consumed remotely. In order to do this, we add `com.permutive.android:core:1.9.5-DEBUG` as a `debugImplementation`. We also need to add the  `android.permission.SYSTEM_ALERT_WINDOW` permission to our `Manifest` file. When we run the app in the debug build variant, it should now appear on using the specified gesture. The default implementation uses a left swipe to show and a right swipe to hide the overlay. 

![Screenshot_20241105_120258](https://github.com/user-attachments/assets/9d3c0dcc-b2ab-45dd-b7f3-853afed56ab5)
