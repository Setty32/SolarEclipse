package test.solareclipse.feature.home.ui

import android.app.Activity
import com.cleverlance.mobile.android.screens.domain.BaseScreen
import com.cleverlance.mobile.android.screens.domain.ScreenFactory
import com.cleverlance.mobile.android.screens.domain.ScreenInvoker
import com.cleverlance.mobile.android.screens.presenter.BasePresenterView
import com.cleverlance.mobile.android.screens.presenter.ScreenPresenter
import io.reactivex.disposables.Disposables
import test.solareclipse.common.injection.ApplicationComponentHolder
import test.solareclipse.common.ui.view.ViewProvider
import test.solareclipse.feature.home.ui.view.HomeView
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class HomeInvoker @Inject internal constructor() : ScreenInvoker() {
    @Inject internal lateinit var componentHolder: ApplicationComponentHolder
    @Inject lateinit override var screenPresenter: ScreenPresenter

    override val screenFactory: ScreenFactory = object : ScreenFactory {
        override fun createScreen(): BaseScreen =
                componentHolder.applicationComponent.plusHomeComponent().homeScreen
    }

    internal fun showScreenAsRoot(activity: Activity) {
        showScreen(Disposables.fromRunnable { activity.finish() })
    }
}

internal class HomeScreen @Inject constructor() : BaseScreen() {
    @Inject internal lateinit var viewProvider: ViewProvider<HomeView>

    override fun createView(): BasePresenterView = viewProvider.createView()
}