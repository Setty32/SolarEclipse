package test.solareclipse.common.injection

import android.content.Context

internal interface ApplicationComponentHolder {
    val applicationComponent: ApplicationComponent
}

internal val Context.injector: ApplicationComponent
    get() = (applicationContext as ApplicationComponentHolder).applicationComponent