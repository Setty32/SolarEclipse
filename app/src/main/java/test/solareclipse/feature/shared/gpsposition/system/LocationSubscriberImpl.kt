package test.solareclipse.feature.shared.gpsposition.system

import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import com.jakewharton.rxrelay2.BehaviorRelay
import test.solareclipse.feature.shared.gpsposition.application.LocationSubscriber


internal class LocationSubscriberImpl(locationManager: LocationManager) : LocationListener, LocationSubscriber {
    private val locationBehaviour = BehaviorRelay.create<Location>()
    private val statusBehaviour = BehaviorRelay.create<Int>()
    private val providerEnabledBehavior = BehaviorRelay.create<String>()
    private val providerDisabledBehavior = BehaviorRelay.create<String>()

    init {
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10f, this)
    }

    override fun onLocationChanged(location: Location?) {
        location?.apply { locationBehaviour.accept(this) }
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        status.apply { statusBehaviour.accept(this) }
    }

    override fun onProviderEnabled(provider: String?) {
        provider?.apply { providerEnabledBehavior.accept(this) }
    }

    override fun onProviderDisabled(provider: String?) {
        provider?.apply { providerDisabledBehavior.accept(this) }
    }

    override fun subscribeOnLocationChange(): BehaviorRelay<Location> = locationBehaviour
    override fun subscribeOnStatusChange(): BehaviorRelay<Int> = statusBehaviour
    override fun subscribeOnProviderEnabled(): BehaviorRelay<String> = providerEnabledBehavior
    override fun subscribeOnProviderDisabled(): BehaviorRelay<String> = providerDisabledBehavior
}