package `fun`.chezcandy.search.github.users.di.builder

import `fun`.chezcandy.search.github.users.ui.main.MainActivityModule
import `fun`.chezcandy.search.github.users.ui.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity
}