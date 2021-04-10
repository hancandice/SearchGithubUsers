package `fun`.chezcandy.search.github.users.di.component

import `fun`.chezcandy.search.github.users.GithubUserApp
import `fun`.chezcandy.search.github.users.di.builder.ActivityBuilder
import `fun`.chezcandy.search.github.users.di.module.AppModule
import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

    fun inject(app: GithubUserApp)
}