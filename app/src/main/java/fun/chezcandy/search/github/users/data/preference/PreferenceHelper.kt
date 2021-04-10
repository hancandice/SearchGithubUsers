package `fun`.chezcandy.search.github.users.data.preference

interface PreferenceHelper {

    fun getCurrentUserId(): Long?

    fun setCurrentUserId(userId: Long?)

    fun getCurrentUserName(): String?

    fun setCurrentUserName(userName: String?)

    fun getCurrentUserEmail(): String?

    fun setCurrentUserEmail(email: String?)

    fun getAccessToken(): String?

    fun setAccessToken(accessToken: String?)

    fun getCurrentUserSignUpDate(): String?

    fun setCurrentUserSignUpDate(signUpDate: String?)

}
