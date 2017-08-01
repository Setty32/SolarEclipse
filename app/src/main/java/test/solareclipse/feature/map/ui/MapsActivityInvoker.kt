package test.solareclipse.feature.map.ui

import android.content.Context
import android.content.Intent
import test.solareclipse.feature.map.ui.view.MapsActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class MapsActivityInvoker @Inject constructor() {
    fun showScreen(context: Context) {
        val intent = Intent(context, MapsActivity::class.java)
        context.startActivity(intent)
    }
}