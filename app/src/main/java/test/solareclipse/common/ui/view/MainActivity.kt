package test.solareclipse.common.ui.view

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import com.cleverlance.mobile.android.screens.dialog.android.DialogScreenViewContainer
import com.cleverlance.mobile.android.screens.domain.Screen
import com.cleverlance.mobile.android.screens.view.ScreenContainerView
import com.cleverlance.mobile.android.screens.view.screenContainerView
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.jetbrains.anko.*
import org.jetbrains.anko.design.coordinatorLayout
import test.solareclipse.common.dialog.MainDialogScreenFlow
import test.solareclipse.common.injection.injector
import test.solareclipse.common.ui.presenter.MainActivityPresenter
import test.solareclipse.feature.home.ui.HomeInvoker
import test.solareclipse.generic.common.hideKeyboard
import test.solareclipse.generic.common.ui.DisposableActivity
import javax.inject.Inject

internal class MainActivity : DisposableActivity() {
    @Inject internal lateinit var presenter: MainActivityPresenter
    @Inject internal lateinit var homeInvoker: HomeInvoker
    @Inject internal lateinit var mainDialogScreenFlow: MainDialogScreenFlow

    private lateinit var root: View

    private lateinit var screenContainerView: ScreenContainerView
    private lateinit var progressView: View
    override fun onCreate(savedInstanceState: Bundle, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        injector.plusMainActivityComponent().inject(this)

        MainActivityUi().setContentView(this)

        if (!presenter.isInitialized.get()) {
            ensureActivation().subscribe(
                    {
                        presenter.isInitialized.set(true)
                        homeInvoker.showScreenAsRoot(this)
                    },
                    {
                        //                        e(it) { "Activation cancelled" }
                        finish()
                    }
            )
        }

    }

    private fun ensureActivation(): Completable {
        return Completable.complete()
    }

    override fun bindDisposables(): Disposable = CompositeDisposable(
            mainDialogScreenFlow.subscribe(DialogScreenViewContainer(this)),
            presenter.screenPresenter.screenObservable().subscribe {
                hideKeyboard()
                updateScreen(it)
            }
    )

    private fun updateScreen(screen: Screen) = screenContainerView.setScreen(screen)

    internal inner class MainActivityUi : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
            coordinatorLayout {
                lparams(matchParent, matchParent)

                relativeLayout {
                    lparams(matchParent, matchParent)

                    verticalLayout {
                        lparams(matchParent, matchParent)

                        owner.screenContainerView = screenContainerView { lparams(matchParent, matchParent) }
                    }

                    owner.progressView = insertProgressLayout()
                }
                relativeLayout {
                    lparams(matchParent, matchParent)

                }

            }.apply { owner.root = this }
        }
    }
}