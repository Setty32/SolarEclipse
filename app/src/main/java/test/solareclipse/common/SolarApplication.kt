package test.solareclipse.common

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import test.solareclipse.common.injection.ApplicationComponent
import test.solareclipse.common.injection.ApplicationComponentHolder
import test.solareclipse.common.injection.ApplicationModule
import test.solareclipse.common.injection.DaggerApplicationComponent
import javax.inject.Singleton

@Singleton
internal class SolarApplication : Application(), ApplicationComponentHolder {
    override lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(this)
        initInjection()
    }

    internal fun initInjection() {
        applicationComponent = createApplicationComponent()
        applicationComponent.inject(this@SolarApplication)
    }

    internal fun createApplicationComponent() = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this)).build()!!
}
