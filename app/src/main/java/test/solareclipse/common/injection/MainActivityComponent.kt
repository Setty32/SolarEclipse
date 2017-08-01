package test.solareclipse.common.injection

import dagger.Subcomponent
import test.solareclipse.common.domain.MainActivityScope
import test.solareclipse.common.ui.view.MainActivity

@MainActivityScope
@Subcomponent
internal interface MainActivityComponent {
    fun inject(activity: MainActivity)
}