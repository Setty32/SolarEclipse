package test.solareclipse.feature.shared.gpsposition.application

import android.location.Location
import com.jakewharton.rxrelay2.BehaviorRelay


internal interface LocationSubscriber {
    fun subscribeOnLocationChange(): BehaviorRelay<Location>

    fun subscribeOnStatusChange(): BehaviorRelay<Int>

    fun subscribeOnProviderEnabled(): BehaviorRelay<String>

    fun subscribeOnProviderDisabled(): BehaviorRelay<String>
}