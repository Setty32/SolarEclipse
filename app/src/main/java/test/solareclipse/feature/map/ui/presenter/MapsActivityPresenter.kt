package test.solareclipse.feature.map.ui.presenter

import android.graphics.Color
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions
import test.solareclipse.feature.home.domain.SolarPoint
import test.solareclipse.feature.map.application.MapController
import test.solareclipse.feature.map.domain.MapsScope
import javax.inject.Inject

@MapsScope
internal class MapsActivityPresenter @Inject internal constructor() {
    @Inject internal lateinit var mapController: MapController

    internal fun bindMap() = OnMapReadyCallback { googleMap ->
        drawAPolyLine(googleMap, mapController, { it.nLimit })
        drawAPolyLine(googleMap, mapController, { it.sLimit })
        drawAPolyLine(googleMap, mapController, { it.cLimit })
    }

    private fun drawAPolyLine(googleMap: GoogleMap, mapController: MapController, selectLine: (SolarPoint) -> LatLng)
            = googleMap.addPolyline(PolylineOptions().color(Color.RED).add(mapController.getEclipseLatLngs().map { selectLine(it) }))


    private fun PolylineOptions.add(arrayOf: List<LatLng>): PolylineOptions = apply { for (position in arrayOf) add(position) }
}
