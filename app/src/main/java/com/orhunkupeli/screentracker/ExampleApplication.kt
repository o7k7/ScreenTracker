package com.orhunkupeli.screentracker

import android.app.Application
import android.util.Log

class ExampleApplication : Application(), ScreenLifecycleListener.Listener {

    companion object {
        var screenTracker: ScreenTracker? = null
    }

    override fun onCreate() {
        super.onCreate()
        screenTracker =
            ScreenTracker.Builder(application = this, listener = this).build().apply { init() }
    }

    override fun onLifecycleEvent(lifecycleEvent: LifecycleEvent) {
        when (lifecycleEvent) {
            is LifecycleEvent.Fragment -> {
                Log.e(
                    "TEST::",
                    lifecycleEvent.fragmentLifecycle + " " + lifecycleEvent.fragment.javaClass.name
                )
            }
            is LifecycleEvent.Activity -> {
                Log.e(
                    "TEST::",
                    lifecycleEvent.activityLifecycle + " " + lifecycleEvent.activity.localClassName
                )
            }
        }
    }
}