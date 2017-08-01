package test.solareclipse.common.ui.presenter

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

internal abstract class RxPresenter {
    internal fun <T> fromIoToMain(single: Single<T>) =
            single.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}