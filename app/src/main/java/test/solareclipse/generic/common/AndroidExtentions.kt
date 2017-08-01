package test.solareclipse.generic.common

import android.app.Activity
import org.jetbrains.anko.inputMethodManager

internal fun Activity.hideKeyboard() {
    currentFocus?.run { inputMethodManager.hideSoftInputFromWindow(windowToken, 0) }
}