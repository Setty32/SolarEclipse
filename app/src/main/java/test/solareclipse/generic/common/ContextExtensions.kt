package test.solareclipse.generic.common

import android.content.Context
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat

internal fun Context.color(@ColorRes res: Int) = ContextCompat.getColor(this, res)
