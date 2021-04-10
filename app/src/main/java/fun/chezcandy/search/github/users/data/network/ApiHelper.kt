package `fun`.chezcandy.search.github.users.data.network

import `fun`.chezcandy.search.github.users.data.network.model.User
import `fun`.chezcandy.search.github.users.data.network.response.UserRepoResponse
import io.reactivex.Observable

interface ApiHelper {

    fun getUserInfo(
        username: String
    ): Observable<User>

    fun getUserRepo(
        username: String
    ): Observable<UserRepoResponse>
}