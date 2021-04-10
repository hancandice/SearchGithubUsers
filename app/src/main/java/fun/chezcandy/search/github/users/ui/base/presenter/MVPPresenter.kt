package `fun`.chezcandy.search.github.users.ui.base.presenter

import `fun`.chezcandy.search.github.users.ui.base.interactor.MVPInteractor
import `fun`.chezcandy.search.github.users.ui.base.view.MVPView

interface MVPPresenter<V : MVPView, I : MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}
