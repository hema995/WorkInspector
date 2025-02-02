package org.hema995.workinspector.ui.workers

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.hema995.workinspector.ui.WorkConstraint

internal data class WorkerItem(
    val name: String,
    val className: String,
    @DrawableRes val stateIcon: Int,
    @StringRes val stateTitle: Int,
    val isPeriodic: Boolean,
    val lastEnqueueTime: Long,
    val constraints: Set<WorkConstraint>,
)
