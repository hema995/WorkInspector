package org.hema995.workinspector.ui.util

import android.content.Context
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.hema995.workinspector.R

internal fun showErrorDialog(
    context: Context,
    error: Throwable,
) {
    MaterialAlertDialogBuilder(context)
        .setTitle(R.string.wi_error_generic)
        .setMessage(error.message)
        .setNegativeButton(android.R.string.ok, null)
        .setCancelable(true)
        .show()
}
