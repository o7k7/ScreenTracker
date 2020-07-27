package com.orhunkupeli.screentracker

sealed class LifecycleEvent {
    data class Activity(
        val activity: android.app.Activity,
        @ActivityLifecycle val activityLifecycle: String
    ) : LifecycleEvent()

    data class Fragment(
        val fragment: androidx.fragment.app.Fragment,
        @FragmentLifecycle val fragmentLifecycle: String
    ) : LifecycleEvent()
}