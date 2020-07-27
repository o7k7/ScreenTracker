package com.orhunkupeli.screentracker

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import java.lang.ref.WeakReference

object ScreenLifecycleListener : BaseObservable<ScreenLifecycleListener.Listener>() {

    interface Listener {
        fun onLifecycleEvent(lifecycleEvent: LifecycleEvent)
    }

    fun register(listener: Listener) {
        super.registerListener(listener)
    }

    fun unregister(listener: Listener) {
        super.unregisterListener(listener)
    }

    fun notifyActivityListeners(@ActivityLifecycle event: String, activity: Activity) {
        super.getListeners().forEach {
            it.onLifecycleEvent(LifecycleEvent.Activity(activity, event))
        }
    }

    fun notifyFragmentListeners(@FragmentLifecycle event: String, fragment: Fragment) {
        super.getListeners().forEach {
            it.onLifecycleEvent(LifecycleEvent.Fragment(fragment, event))
        }
    }

    fun getLifecycleListener() = object :
        Application.ActivityLifecycleCallbacks {
        private var weakReference: WeakReference<FragmentManager.FragmentLifecycleCallbacks?>? =
            null

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            weakReference = WeakReference(registerToFragmentLifecycle(activity))
            notifyActivityListeners(ActivityLifecycle.ON_CREATE, activity)
        }

        override fun onActivityStarted(activity: Activity) {
            notifyActivityListeners(ActivityLifecycle.ON_START, activity)
        }

        override fun onActivityResumed(activity: Activity) {
            notifyActivityListeners(ActivityLifecycle.ON_RESUME, activity)
        }

        override fun onActivityPaused(activity: Activity) {
            notifyActivityListeners(ActivityLifecycle.ON_PAUSE, activity)
        }

        override fun onActivityStopped(activity: Activity) {
            notifyActivityListeners(ActivityLifecycle.ON_STOP, activity)
        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {
            notifyActivityListeners(ActivityLifecycle.ON_SAVE_INSTANCE_STATE, activity)
        }

        override fun onActivityDestroyed(activity: Activity) {
            notifyActivityListeners(ActivityLifecycle.ON_DESTROY, activity)
            if (weakReference != null) {
                unregisterToFragmentLifecycle(activity, weakReference?.get())
                weakReference?.clear()
            }
        }
    }

    private fun unregisterToFragmentLifecycle(
        activity: Activity,
        callbacks: FragmentManager.FragmentLifecycleCallbacks?
    ) {
        if (callbacks != null && activity is FragmentActivity) {
            val supportFragmentManager = activity.supportFragmentManager
            supportFragmentManager.unregisterFragmentLifecycleCallbacks(callbacks)
        }
    }

    private fun registerToFragmentLifecycle(
        activity: Activity
    ): FragmentManager.FragmentLifecycleCallbacks? {
        if (activity is FragmentActivity) {
            val supportFragmentManager = activity.supportFragmentManager
            val fragmentLifecycleCallbacks: FragmentManager.FragmentLifecycleCallbacks =
                object : FragmentManager.FragmentLifecycleCallbacks() {
                    override fun onFragmentPreAttached(
                        fragmentManager: FragmentManager,
                        fragment: Fragment,
                        context: Context
                    ) {
                        super.onFragmentPreAttached(fragmentManager, fragment, context)
                        notifyFragmentListeners(FragmentLifecycle.ON_PRE_ATTACH, fragment)
                    }

                    override fun onFragmentAttached(
                        fragmentManager: FragmentManager,
                        fragment: Fragment,
                        context: Context
                    ) {
                        super.onFragmentAttached(fragmentManager, fragment, context)
                        notifyFragmentListeners(FragmentLifecycle.ON_ATTACH, fragment)
                    }

                    override fun onFragmentCreated(
                        fragmentManager: FragmentManager,
                        fragment: Fragment,
                        savedInstanceState: Bundle?
                    ) {
                        super.onFragmentCreated(fragmentManager, fragment, savedInstanceState)
                        notifyFragmentListeners(FragmentLifecycle.ON_CREATE, fragment)
                    }

                    override fun onFragmentActivityCreated(
                        fragmentManager: FragmentManager,
                        fragment: Fragment,
                        savedInstanceState: Bundle?
                    ) {
                        super.onFragmentActivityCreated(
                            fragmentManager,
                            fragment,
                            savedInstanceState
                        )
                        notifyFragmentListeners(FragmentLifecycle.ON_ACTIVITY_CREATE, fragment)
                    }

                    override fun onFragmentPreCreated(
                        fragmentManager: FragmentManager,
                        fragment: Fragment,
                        savedInstanceState: Bundle??
                    ) {
                        super.onFragmentPreCreated(fragmentManager, fragment, savedInstanceState)
                        notifyFragmentListeners(FragmentLifecycle.ON_PRE_CREATE, fragment)
                    }

                    override fun onFragmentViewCreated(
                        fragmentManager: FragmentManager,
                        fragment: Fragment,
                        view: View,
                        savedInstanceState: Bundle?
                    ) {
                        super.onFragmentViewCreated(
                            fragmentManager,
                            fragment,
                            view,
                            savedInstanceState
                        )
                        notifyFragmentListeners(FragmentLifecycle.ON_VIEW_CREATED, fragment)
                    }

                    override fun onFragmentStarted(
                        fragmentManager: FragmentManager,
                        fragment: Fragment
                    ) {
                        super.onFragmentStarted(fragmentManager, fragment)
                        notifyFragmentListeners(FragmentLifecycle.ON_START, fragment)
                    }

                    override fun onFragmentResumed(
                        fragmentManager: FragmentManager,
                        fragment: Fragment
                    ) {
                        super.onFragmentResumed(fragmentManager, fragment)
                        notifyFragmentListeners(FragmentLifecycle.ON_RESUME, fragment)
                    }

                    override fun onFragmentPaused(
                        fragmentManager: FragmentManager,
                        fragment: Fragment
                    ) {
                        super.onFragmentPaused(fragmentManager, fragment)
                        notifyFragmentListeners(FragmentLifecycle.ON_PAUSE, fragment)
                    }

                    override fun onFragmentStopped(
                        fragmentManager: FragmentManager,
                        fragment: Fragment
                    ) {
                        super.onFragmentStopped(fragmentManager, fragment)
                        notifyFragmentListeners(FragmentLifecycle.ON_STOP, fragment)
                    }

                    override fun onFragmentSaveInstanceState(
                        fragmentManager: FragmentManager,
                        fragment: Fragment,
                        outState: Bundle
                    ) {
                        super.onFragmentSaveInstanceState(fragmentManager, fragment, outState)
                        notifyFragmentListeners(FragmentLifecycle.ON_SAVE_INSTANCE_STATE, fragment)
                    }

                    override fun onFragmentViewDestroyed(
                        fragmentManager: FragmentManager,
                        fragment: Fragment
                    ) {
                        super.onFragmentViewDestroyed(fragmentManager, fragment)
                        notifyFragmentListeners(FragmentLifecycle.ON_VIEW_DESTROY, fragment)
                    }

                    override fun onFragmentDestroyed(
                        fragmentManager: FragmentManager,
                        fragment: Fragment
                    ) {
                        super.onFragmentDestroyed(fragmentManager, fragment)
                        notifyFragmentListeners(FragmentLifecycle.ON_DESTROY, fragment)
                    }

                    override fun onFragmentDetached(
                        fragmentManager: FragmentManager,
                        fragment: Fragment
                    ) {
                        super.onFragmentDetached(fragmentManager, fragment)
                        notifyFragmentListeners(FragmentLifecycle.ON_DETACH, fragment)
                    }
                }
            supportFragmentManager.registerFragmentLifecycleCallbacks(
                fragmentLifecycleCallbacks,
                true
            )
            return fragmentLifecycleCallbacks
        }
        return null
    }
}