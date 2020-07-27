package com.orhunkupeli.screentracker

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ScreenLifecycleListener.Listener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({
            Intent(this, SideActivity::class.java).apply {
                startActivity(this)
            }
        }, 5000)

        ExampleApplication.screenTracker!!.registerListener(this)
    }

    override fun onLifecycleEvent(lifecycleEvent: LifecycleEvent) {
        when (lifecycleEvent) {
            is LifecycleEvent.Activity -> {
                Log.e(
                    "TEST::",
                    lifecycleEvent.activityLifecycle + " MAIN " + lifecycleEvent.activity.localClassName
                )
            }
            is LifecycleEvent.Fragment -> {
                Log.e(
                    "TEST::",
                    lifecycleEvent.fragmentLifecycle + " MAIN " + lifecycleEvent.fragment.javaClass.name
                )
            }
        }
    }

    override fun onDestroy() {
        ExampleApplication.screenTracker!!.unregisterListener(this)
        super.onDestroy()
    }
}