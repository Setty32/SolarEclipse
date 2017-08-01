package test.solareclipse.feature.home.ui.view

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.cleverlance.mobile.android.screens.presenter.BaseAnkoPresenterView
import com.jakewharton.rxbinding2.view.RxMenuItem
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.view.RxView.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.jetbrains.anko.*
import test.solareclipse.R
import test.solareclipse.feature.home.ui.presenter.HomePresenter
import javax.inject.Inject

internal class HomeView @Inject internal constructor() : BaseAnkoPresenterView() {
    @Inject internal lateinit var presenter : HomePresenter

    private lateinit var welcomeText: TextView
    private lateinit var clickHereButton: Button

    override fun bindPresenter(): Disposable = CompositeDisposable(
            clicks(clickHereButton).subscribe { presenter.showMap(this.activity) }
    )

    override fun createAnkoView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        verticalLayout {
            lparams(matchParent, matchParent)

            welcomeText = textView(resources.getString(R.string.welcome_text)) {
                gravity = Gravity.CENTER
            }.lparams(matchParent, wrapContent) {
                gravity = Gravity.CENTER
            }

            clickHereButton = button(R.string.show_map){
                lparams(matchParent, wrapContent)
            }
        }
    }
}