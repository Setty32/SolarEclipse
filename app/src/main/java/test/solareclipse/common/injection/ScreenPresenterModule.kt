package test.solareclipse.common.injection

import com.cleverlance.mobile.android.screens.presenter.ScreenPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class ScreenPresenterModule {
    @Singleton
    @Provides
    fun providesScreenPresenter() = ScreenPresenter()
}