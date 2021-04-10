package `fun`.chezcandy.search.github.users.data.network

import `fun`.chezcandy.search.github.users.data.network.model.User
import `fun`.chezcandy.search.github.users.data.network.response.UserRepoResponse
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import okhttp3.OkHttpClient
import javax.inject.Inject

class AppApiHelper @Inject constructor(
    private val apiHeader: ApiHeader,
    private val okHttpClient: OkHttpClient
) : ApiHelper {

    override fun getUserInfo(
        username: String
    ): Observable<User> {
        val url =
            ApiEndPoint.USER_INFO_BASE_URL + "/$username"

        return Rx2AndroidNetworking.get(url)
            .addHeaders(apiHeader.protectedApiHeader)
            .setOkHttpClient(okHttpClient)
            .build()
            .getObjectObservable(User::class.java)
    }

    override fun getUserRepo(
        username: String
    ): Observable<UserRepoResponse> {
        val url = ApiEndPoint.USER_INFO_BASE_URL + "/$username/repos"

        return Rx2AndroidNetworking.post(url)
            .addHeaders(apiHeader.protectedApiHeader)
            .setOkHttpClient(okHttpClient)
            .build()
            .getObjectObservable(UserRepoResponse::class.java)
    }
}