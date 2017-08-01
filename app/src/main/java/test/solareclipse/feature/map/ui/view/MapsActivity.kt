package test.solareclipse.feature.map.ui.view

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.google.android.gms.maps.SupportMapFragment
import test.solareclipse.R
import test.solareclipse.common.injection.injector
import test.solareclipse.feature.map.ui.presenter.MapsActivityPresenter
import javax.inject.Inject

internal class MapsActivity : FragmentActivity() {
    @Inject internal lateinit var presenter: MapsActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        injector.plusMapsActivityComponent().inject(this)

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(presenter.bindMap())
    }
}
