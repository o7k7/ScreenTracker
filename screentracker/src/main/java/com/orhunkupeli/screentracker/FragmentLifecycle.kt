package com.orhunkupeli.screentracker

import androidx.annotation.StringDef
import com.orhunkupeli.screentracker.FragmentLifecycle.Companion.ON_ACTIVITY_CREATE
import com.orhunkupeli.screentracker.FragmentLifecycle.Companion.ON_ATTACH
import com.orhunkupeli.screentracker.FragmentLifecycle.Companion.ON_CREATE
import com.orhunkupeli.screentracker.FragmentLifecycle.Companion.ON_DESTROY
import com.orhunkupeli.screentracker.FragmentLifecycle.Companion.ON_DETACH
import com.orhunkupeli.screentracker.FragmentLifecycle.Companion.ON_PAUSE
import com.orhunkupeli.screentracker.FragmentLifecycle.Companion.ON_PRE_ATTACH
import com.orhunkupeli.screentracker.FragmentLifecycle.Companion.ON_PRE_CREATE
import com.orhunkupeli.screentracker.FragmentLifecycle.Companion.ON_RESUME
import com.orhunkupeli.screentracker.FragmentLifecycle.Companion.ON_SAVE_INSTANCE_STATE
import com.orhunkupeli.screentracker.FragmentLifecycle.Companion.ON_START
import com.orhunkupeli.screentracker.FragmentLifecycle.Companion.ON_STOP
import com.orhunkupeli.screentracker.FragmentLifecycle.Companion.ON_VIEW_CREATED
import com.orhunkupeli.screentracker.FragmentLifecycle.Companion.ON_VIEW_DESTROY

@Retention(AnnotationRetention.SOURCE)
@StringDef(
    ON_PRE_ATTACH,
    ON_ATTACH,
    ON_CREATE,
    ON_ACTIVITY_CREATE,
    ON_PRE_CREATE,
    ON_VIEW_CREATED,
    ON_START,
    ON_RESUME,
    ON_PAUSE,
    ON_STOP,
    ON_SAVE_INSTANCE_STATE,
    ON_DESTROY,
    ON_VIEW_DESTROY,
    ON_DETACH
)
annotation class FragmentLifecycle {
    companion object {
        const val ON_PRE_ATTACH = "ON_PRE_ATTACH"
        const val ON_ATTACH = "ON_ATTACH"
        const val ON_ACTIVITY_CREATE = "ON_ACTIVITY_CREATE"
        const val ON_CREATE = "ON_CREATE"
        const val ON_PRE_CREATE = "ON_PRE_CREATE"
        const val ON_VIEW_CREATED = "ON_VIEW_CREATED"
        const val ON_START = "ON_START"
        const val ON_RESUME = "ON_RESUME"
        const val ON_PAUSE = "ON_PAUSE"
        const val ON_STOP = "ON_STOP"
        const val ON_SAVE_INSTANCE_STATE = "ON_SAVE_INSTANCE_STATE"
        const val ON_DESTROY = "ON_DESTROY"
        const val ON_VIEW_DESTROY = "ON_VIEW_DESTROY"
        const val ON_DETACH = "ON_DETACH"
    }
}