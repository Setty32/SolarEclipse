package test.solareclipse.common.ui.view

import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*
import test.solareclipse.R
import test.solareclipse.generic.common.color


internal fun _RelativeLayout.insertProgressLayout() = with(this) {
    linearLayout {
        lparams(matchParent, matchParent)
        visibility = View.GONE
        backgroundColor = context.color(R.color.white_aplha50)
        gravity = Gravity.CENTER
        setOnTouchListener { _, _ -> true }

        progressBar { isIndeterminate = true }.lparams(wrapContent, wrapContent)
    }
}