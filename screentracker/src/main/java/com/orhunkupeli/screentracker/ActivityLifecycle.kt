package com.orhunkupeli.screentracker

import androidx.annotation.StringDef
import com.orhunkupeli.screentracker.ActivityLifecycle.Companion.ON_CREATE
import com.orhunkupeli.screentracker.ActivityLifecycle.Companion.ON_DESTROY
import com.orhunkupeli.screentracker.ActivityLifecycle.Companion.ON_PAUSE
import com.orhunkupeli.screentracker.ActivityLifecycle.Companion.ON_RESTART
import com.orhunkupeli.screentracker.ActivityLifecycle.Companion.ON_RESUME
import com.orhunkupeli.screentracker.ActivityLifecycle.Companion.ON_SAVE_INSTANCE_STATE
import com.orhunkupeli.screentracker.ActivityLifecycle.Companion.ON_START
import com.orhunkupeli.screentracker.ActivityLifecycle.Companion.ON_STOP

@Retention(AnnotationRetention.SOURCE)
@StringDef(
    ON_CREATE,
    ON_START,
    ON_RESUME,
    ON_PAUSE,
    ON_RESTART,
    ON_STOP,
    ON_DESTROY,
    ON_SAVE_INSTANCE_STATE
)
annotation class ActivityLifecycle {
    companion object {
        const val ON_CREATE = "ON_CREATE"
        const val ON_START = "ON_START"
        const val ON_RESUME = "ON_RESUME"
        const val ON_PAUSE = "ON_PAUSE"
        const val ON_STOP = "ON_STOP"
        const val ON_RESTART = "ON_RESTART"
        const val ON_SAVE_INSTANCE_STATE = "ON_SAVE_INSTANCE_STATE"
        const val ON_DESTROY = "ON_DESTROY"
    }
}