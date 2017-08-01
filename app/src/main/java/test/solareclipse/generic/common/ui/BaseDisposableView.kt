package test.solareclipse.generic.common.ui

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import test.solareclipse.generic.common.then

internal interface BaseDisposableView {
    var disposables: CompositeDisposable

    fun bindIfNotYet() = disposables.isDisposed.then { disposables = CompositeDisposable(bindDisposables()) }

    fun bindDisposables(): Disposable

    fun dispose() = disposables.dispose()

    fun addDisposable(disposable: Disposable) = disposables.add(disposable)

    fun removeDisposable(disposable: Disposable) = disposables.remove(disposable)
}