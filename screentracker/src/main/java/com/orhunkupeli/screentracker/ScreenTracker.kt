package com.orhunkupeli.screentracker

import android.app.Application

class ScreenTracker private constructor(
    private val application: Application? = null,
    private val listener: ScreenLifecycleListener.Listener? = null
) {
    data class Builder(
        var application: Application? = null,
        var listener: ScreenLifecycleListener.Listener? = null
    ) {
        fun application(application: Application) = apply {
            this.application = application
        }

        fun listener(listener: ScreenLifecycleListener.Listener) =
            apply {
                this.listener = listener
            }

        fun build() = ScreenTracker(application, listener)
    }

    fun init() {
        application?.registerActivityLifecycleCallbacks(
            ScreenLifecycleListener.getLifecycleListener()
        )
        ScreenLifecycleListener.register(listener!!)
    }

    fun registerListener(listener: ScreenLifecycleListener.Listener?) {
        ScreenLifecycleListener.register(listener!!)
    }

    fun unregisterListener(listener: ScreenLifecycleListener.Listener?) {
        ScreenLifecycleListener.unregister(listener!!)
    }
}