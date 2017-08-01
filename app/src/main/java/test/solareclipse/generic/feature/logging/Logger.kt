package test.solareclipse.generic.feature.logging

import android.util.Log
import test.solareclipse.BuildConfig

internal interface Logger {
    private companion object {
        private const val MAX_TAG_LENGTH = 23
    }

    val tag: String
        get() = with(javaClass.simpleName) {
            if (length <= MAX_TAG_LENGTH) this else substring(0, MAX_TAG_LENGTH)
        }

    val enabled: Boolean
        get() = BuildConfig.DEBUG
}

internal inline fun Logger.v(thr: Throwable? = null, msg: () -> Any?) {
    log(this, msg, thr,
            { tag, msg -> Log.v(tag, msg) },
            { tag, msg, thr -> Log.v(tag, msg, thr) })
}

internal inline fun Logger.d(thr: Throwable? = null, msg: () -> Any?) {
    log(this, msg, thr,
            { tag, msg -> Log.d(tag, msg) },
            { tag, msg, thr -> Log.d(tag, msg, thr) })
}

internal inline fun Logger.i(thr: Throwable? = null, msg: () -> Any?) {
    log(this, msg, thr,
            { tag, msg -> Log.i(tag, msg) },
            { tag, msg, thr -> Log.i(tag, msg, thr) })
}

internal inline fun Logger.w(thr: Throwable? = null, msg: () -> Any?) {
    log(this, msg, thr,
            { tag, msg -> Log.w(tag, msg) },
            { tag, msg, thr -> Log.w(tag, msg, thr) })
}

internal inline fun Logger.e(thr: Throwable? = null, msg: () -> Any?) {
    log(this, msg, thr,
            { tag, msg -> Log.e(tag, msg) },
            { tag, msg, thr -> Log.e(tag, msg, thr) })
}

internal inline fun Logger.wtf(thr: Throwable? = null, msg: () -> Any?) {
    log(this, msg, thr,
            { tag, msg -> Log.wtf(tag, msg) },
            { tag, msg, thr -> Log.wtf(tag, msg, thr) })
}

private inline fun log(logger: Logger, msg: () -> Any?, thr: Throwable?,
                       f: (String, String) -> Unit,
                       fThr: (String, String, Throwable) -> Unit) {
    if (logger.enabled) {
        val tag = logger.tag
        with(msg()?.toString() ?: "null") {
            if (thr != null) fThr(tag, this, thr)
            else f(tag, this)
        }
    }
}