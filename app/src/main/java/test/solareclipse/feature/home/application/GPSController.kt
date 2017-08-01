package test.solareclipse.feature.home.application

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import io.reactivex.Observable
import test.solareclipse.common.SolarApplication
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class GPSController @Inject constructor() {
    @Inject internal lateinit var application: SolarApplication

    fun getLocationObservable(locationChanged: (Location) -> Unit) = Observable.just(getLocationManager().requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10f, getLocationListener(locationChanged)))!!

    private fun getLocationListener(locationChanged: (Location) -> Unit): LocationListener {
        return object : LocationListener {
            override fun onLocationChanged(location: Location) = locationChanged(location)
            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
            override fun onProviderEnabled(provider: String?) {}
            override fun onProviderDisabled(provider: String?) {}
        }
    }

    private fun getLocationManager() = (application.getSystemService(Context.LOCATION_SERVICE) as LocationManager)
}