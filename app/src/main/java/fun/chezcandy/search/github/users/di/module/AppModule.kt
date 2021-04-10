package `fun`.chezcandy.search.github.users.di.module

import `fun`.chezcandy.search.github.users.data.network.ApiHeader
import `fun`.chezcandy.search.github.users.data.network.ApiHelper
import `fun`.chezcandy.search.github.users.data.network.AppApiHelper
import `fun`.chezcandy.search.github.users.data.preference.AppPreferenceHelper
import `fun`.chezcandy.search.github.users.data.preference.PreferenceHelper
import `fun`.chezcandy.search.github.users.di.ApiKeyInfo
import `fun`.chezcandy.search.github.users.di.PreferenceInfo
import `fun`.chezcandy.search.github.users.util.AppConstants
import `fun`.chezcandy.search.github.users.util.SchedulerProvider
import android.app.Application
import android.content.Context
import androidx.room.Room
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @ApiKeyInfo
    internal fun provideApiKey(): String = AppConstants.API_KEY

    @Provides
    @PreferenceInfo
    internal fun providePrefFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper

    @Provides
    @Singleton
    internal fun provideProtectedApiHeader(@ApiKeyInfo apiKey: String, preferenceHelper: PreferenceHelper)
            : ApiHeader.ProtectedApiHeader = ApiHeader.ProtectedApiHeader(apiKey = apiKey,
        userId = preferenceHelper.getCurrentUserId(),
        accessToken = preferenceHelper.getAccessToken())

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()

    @Provides
    @Singleton
    internal fun provideOkHttpClient(
        interceptor: HttpLoggingInterceptor,
        context: Context
    ) : OkHttpClient {
        val b = OkHttpClient.Builder()
            .connectTimeout(30000, java.util.concurrent.TimeUnit.MILLISECONDS)
            .writeTimeout(30000, java.util.concurrent.TimeUnit.MILLISECONDS)
            .readTimeout(30000, java.util.concurrent.TimeUnit.MILLISECONDS)
        b.addInterceptor(interceptor)
        val cookieJar = PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(context))
        b.cookieJar(cookieJar)

        return b.build()
    }

    @Provides
    @Singleton
    internal fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
    }

}