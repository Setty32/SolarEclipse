package test.solareclipse.feature.shared.gpsposition.application

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class GPSController @Inject internal constructor() {
    @Inject internal lateinit var locationSubscriber: LocationSubscriber

    internal fun getLocation() = locationSubscriber.subscribeOnLocationChange()

    internal fun checkStatus(){
        locationSubscriber.subscribeOnStatusChange()
    }

    internal fun checkGPSProvider() : Disposable = CompositeDisposable(
            locationSubscriber.subscribeOnProviderEnabled().subscribe(),    //TODO
            locationSubscriber.subscribeOnProviderDisabled().subscribe()    //TODO
    )
}