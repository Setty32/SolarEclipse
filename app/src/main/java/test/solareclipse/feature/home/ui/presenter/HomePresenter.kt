package test.solareclipse.feature.home.ui.presenter

import android.content.Context
import test.solareclipse.feature.home.domain.HomeScope
import test.solareclipse.feature.map.ui.MapsActivityInvoker
import javax.inject.Inject

@HomeScope
internal class HomePresenter @Inject constructor() {
    @Inject internal lateinit var mapsInvoker: MapsActivityInvoker

    internal fun showMap(context: Context) = mapsInvoker.showScreen(context)
}