package `fun`.chezcandy.search.github.users.ui.base.presenter

import `fun`.chezcandy.search.github.users.ui.base.interactor.MVPInteractor
import `fun`.chezcandy.search.github.users.ui.base.view.MVPView
import `fun`.chezcandy.search.github.users.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<V : MVPView, I : MVPInteractor> internal constructor(
    protected var interactor: I?,
    protected val schedulerProvider: SchedulerProvider,
    protected val compositeDisposable: CompositeDisposable
) : MVPPresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }
}