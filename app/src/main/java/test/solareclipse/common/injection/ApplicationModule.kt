package test.solareclipse.common.injection

import dagger.Module
import dagger.Provides
import test.solareclipse.common.SolarApplication
import javax.inject.Singleton

@Module
internal class ApplicationModule(val application: SolarApplication) {
    @Singleton
    @Provides
    fun providesApplication() = application

    @Singleton
    @Provides
    fun providesApplicationContext() = application.applicationContext!!

    @Singleton
    @Provides
    fun providesResources() = application.resources!!

    @Singleton
    @Provides
    fun providesApplicationComponentHolder(): ApplicationComponentHolder = application
}