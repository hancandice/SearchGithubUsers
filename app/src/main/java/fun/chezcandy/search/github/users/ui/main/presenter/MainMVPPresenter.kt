package `fun`.chezcandy.search.github.users.ui.main.presenter

import `fun`.chezcandy.search.github.users.ui.base.presenter.MVPPresenter
import `fun`.chezcandy.search.github.users.ui.main.interactor.MainMVPInteractor
import `fun`.chezcandy.search.github.users.ui.main.view.MainMVPView
import com.google.android.material.bottomnavigation.BottomNavigationView

interface MainMVPPresenter<V : MainMVPView, I : MainMVPInteractor> : MVPPresenter<V, I> {
}