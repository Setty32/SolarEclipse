package test.solareclipse.feature.map.injection

import dagger.Subcomponent
import test.solareclipse.feature.map.domain.MapsScope
import test.solareclipse.feature.map.ui.view.MapsActivity

@MapsScope
@Subcomponent
internal interface MapsActivityComponent {
    fun inject(mapsActivity: MapsActivity)
}