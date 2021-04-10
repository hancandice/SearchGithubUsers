package `fun`.chezcandy.search.github.users.ui.main.view

import `fun`.chezcandy.search.github.users.R
import `fun`.chezcandy.search.github.users.ui.base.view.BaseActivity
import `fun`.chezcandy.search.github.users.ui.main.interactor.MainMVPInteractor
import `fun`.chezcandy.search.github.users.ui.main.presenter.MainMVPPresenter
import android.app.ActionBar
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : BaseActivity(), MainMVPView {

    @Inject
    internal lateinit var presenter: MainMVPPresenter<MainMVPView, MainMVPInteractor>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun onFragmentAttached() {
        TODO("Not yet implemented")
    }

    override fun onFragmentDetached(tag: String) {
        TODO("Not yet implemented")
    }

}