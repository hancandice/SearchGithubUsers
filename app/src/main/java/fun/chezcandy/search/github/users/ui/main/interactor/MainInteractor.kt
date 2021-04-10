package `fun`.chezcandy.search.github.users.ui.main.interactor

import `fun`.chezcandy.search.github.users.data.network.ApiHelper
import `fun`.chezcandy.search.github.users.data.preference.PreferenceHelper
import `fun`.chezcandy.search.github.users.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class MainInteractor @Inject internal constructor(
    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) : BaseInteractor(
    preferenceHelper = preferenceHelper,
    apiHelper = apiHelper
), MainMVPInteractor {}