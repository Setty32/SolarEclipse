package test.solareclipse.common.ui.presenter

import com.cleverlance.mobile.android.screens.presenter.ScreenPresenter
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class MainActivityPresenter @Inject internal constructor() {
    @Inject internal lateinit var screenPresenter: ScreenPresenter

    internal val isInitialized = AtomicBoolean(false)
    internal val shouldHideShadow = AtomicBoolean(false)
}