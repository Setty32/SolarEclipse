package test.solareclipse.common.ui.view

import com.cleverlance.mobile.android.screens.domain.ViewFactory
import com.cleverlance.mobile.android.screens.presenter.BasePresenterView
import javax.inject.Inject
import javax.inject.Provider

class ViewProvider<V : BasePresenterView> @Inject constructor() : ViewFactory {
    @Inject internal lateinit var viewProvider: Provider<V>

    override fun createView() = viewProvider.get()!!
}