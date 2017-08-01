package test.solareclipse.feature.home.domain

import com.google.android.gms.maps.model.LatLng
import org.threeten.bp.LocalDateTime
import org.threeten.bp.LocalTime

internal data class SolarPoint(
        internal val time: LocalDateTime,
        internal val nLimit: LatLng,
        internal val sLimit: LatLng,
        internal val cLimit: LatLng,
        internal val diamRatio: Double,
        internal val sunAlt: Int,
        internal val sunAzim: Int,
        internal val pathWidth: Int,
        internal val centralDur: LocalTime
)