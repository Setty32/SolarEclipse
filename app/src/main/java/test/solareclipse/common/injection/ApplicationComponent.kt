package test.solareclipse.common.injection

import dagger.Component
import test.solareclipse.common.SolarApplication
import test.solareclipse.feature.home.injection.HomeComponent
import test.solareclipse.feature.map.injection.MapsActivityComponent
import test.solareclipse.feature.shared.gpsposition.injection.GPSModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        ScreenPresenterModule::class,
        GPSModule::class
))
internal interface ApplicationComponent {
    fun inject(application: SolarApplication)

    fun plusMainActivityComponent(): MainActivityComponent

    fun plusMapsActivityComponent(): MapsActivityComponent

    fun plusHomeComponent(): HomeComponent
}