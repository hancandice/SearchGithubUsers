package `fun`.chezcandy.search.github.users.ui.main.presenter

import `fun`.chezcandy.search.github.users.ui.base.presenter.BasePresenter
import `fun`.chezcandy.search.github.users.ui.main.interactor.MainMVPInteractor
import `fun`.chezcandy.search.github.users.ui.main.view.MainMVPView
import `fun`.chezcandy.search.github.users.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class MainPresenter<V : MainMVPView, I : MainMVPInteractor> @Inject internal constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable
) : BasePresenter<V, I>(
    interactor = interactor,
    schedulerProvider = schedulerProvider,
    compositeDisposable = disposable
), MainMVPPresenter<V, I> {

}
