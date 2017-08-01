package test.solareclipse.feature.home.injection

import dagger.Subcomponent
import test.solareclipse.feature.home.domain.HomeScope
import test.solareclipse.feature.home.ui.HomeScreen

@HomeScope
@Subcomponent
internal interface HomeComponent {
    val homeScreen: HomeScreen
}