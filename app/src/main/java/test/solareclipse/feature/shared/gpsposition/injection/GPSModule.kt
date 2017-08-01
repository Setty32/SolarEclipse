package test.solareclipse.feature.shared.gpsposition.injection

import android.app.Application
import android.content.Context
import android.location.LocationManager
import dagger.Module
import dagger.Provides
import test.solareclipse.feature.shared.gpsposition.application.LocationSubscriber
import test.solareclipse.feature.shared.gpsposition.system.LocationSubscriberImpl
import javax.inject.Singleton

@Module
internal class GPSModule {
    @Provides
    @Singleton
    fun providesLocationManager(application: Application) = application.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    @Provides
    @Singleton
    fun providesLocationListener(locationManager: LocationManager): LocationSubscriber = LocationSubscriberImpl(locationManager)
}