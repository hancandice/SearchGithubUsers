package `fun`.chezcandy.search.github.users.ui.main

import `fun`.chezcandy.search.github.users.ui.main.interactor.MainInteractor
import `fun`.chezcandy.search.github.users.ui.main.interactor.MainMVPInteractor
import `fun`.chezcandy.search.github.users.ui.main.presenter.MainMVPPresenter
import `fun`.chezcandy.search.github.users.ui.main.presenter.MainPresenter
import `fun`.chezcandy.search.github.users.ui.main.view.MainMVPView
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    internal fun provideMainInteractor(mainInteractor: MainInteractor): MainMVPInteractor =
        mainInteractor

    @Provides
    internal fun provideMainPresenter(mainPresenter: MainPresenter<MainMVPView, MainMVPInteractor>)
            : MainMVPPresenter<MainMVPView, MainMVPInteractor> = mainPresenter

}