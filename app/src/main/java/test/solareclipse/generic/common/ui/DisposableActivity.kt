package test.solareclipse.generic.common.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable

internal abstract class DisposableActivity : AppCompatActivity(), BaseDisposableView {
    override var disposables = CompositeDisposable().apply { dispose() }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        bindIfNotYet()
    }

    override fun onDestroy() {
        super.onDestroy()

        dispose()
    }
}