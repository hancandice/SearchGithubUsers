package `fun`.chezcandy.search.github.users.ui.base.interactor

import `fun`.chezcandy.search.github.users.data.network.ApiHelper
import `fun`.chezcandy.search.github.users.data.preference.PreferenceHelper

open class BaseInteractor() : MVPInteractor {

    protected lateinit var preferenceHelper: PreferenceHelper
    protected lateinit var apiHelper: ApiHelper

    constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : this() {
        this.preferenceHelper = preferenceHelper
        this.apiHelper = apiHelper
    }

}