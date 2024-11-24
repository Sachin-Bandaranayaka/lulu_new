package com.lulu.enterprises

import android.os.Build
import android.os.Bundle
import com.facebook.react.ReactActivity
import com.facebook.react.ReactActivityDelegate
import com.facebook.react.defaults.DefaultReactActivityDelegate
import expo.modules.ReactActivityDelegateWrapper

class MainActivity : ReactActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
      // Set the theme to AppTheme BEFORE onCreate to support
      // coloring the background, status bar, and navigation bar.
      // This is required for expo-splash-screen.
      setTheme(com.lulu.enterprises.R.style.AppTheme)
      super.onCreate(null)
  }

  /**
   * Returns the name of the main component registered from JavaScript.
   */
  override fun getMainComponentName(): String = "main"

  /**
   * Returns the instance of the [ReactActivityDelegate].
   */
  override fun createReactActivityDelegate(): ReactActivityDelegate {
      return ReactActivityDelegateWrapper(
          this,
          false, // Changed from BuildConfig.IS_NEW_ARCHITECTURE_ENABLED to false
          DefaultReactActivityDelegate(
              this,
              mainComponentName,
              false // Changed from fabricEnabled to false
          )
      )
  }

  /**
   * Align the back button behavior with Android S
   * where moving root activities to background instead of finishing activities.
   */
  override fun invokeDefaultOnBackPressed() {
      if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.R) {
          if (!moveTaskToBack(false)) {
              super.invokeDefaultOnBackPressed()
          }
          return
      }
      super.invokeDefaultOnBackPressed()
  }
}