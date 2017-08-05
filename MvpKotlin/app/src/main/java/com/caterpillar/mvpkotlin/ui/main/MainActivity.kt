package com.caterpillar.mvpkotlin.ui.main

import android.support.v7.widget.LinearLayoutManager
import com.caterpillar.mvpkotlin.R
import com.caterpillar.mvpkotlin.adapter.MainAdapter
import com.caterpillar.mvpkotlin.application.AppComponent
import com.caterpillar.mvpkotlin.data.User
import com.caterpillar.mvpkotlin.persenter.MainPresenter
import com.caterpillar.mvpkotlin.ui.base.BaseActivity
import com.caterpillar.mvpkotlin.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk25.coroutines.onClick
import javax.inject.Inject


class MainActivity : BaseActivity(), MainView, MainAdapter.OnItemClickListener {

    override fun onItemClick(user: User) {
        startActivity(intentFor<DetailActivity>("user" to user))
    }

    //使用dagger2来注入
    @Inject
    lateinit var presenter : MainPresenter

    @Inject
    lateinit var adapter : MainAdapter

    override fun attachLayoutId(): Int  = R.layout.activity_main

    override fun initViews() {
        //比butter knife简单多了
        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        mainRecyclerView.adapter = adapter
        adapter.onItemClick = this
        mainSearch.onClick {
            val key = mainEdit.text.toString()
            //通过Presenter
            presenter.getUsers(key)
        }
    }

    override fun setUpComponent(appComponent: AppComponent) {
        DaggerMainActivityComponent.
                builder()
                .appComponent(appComponent)
                .mainActivityModule(MainActivityModule(this@MainActivity))
                .build().inject(this@MainActivity)
    }


    override fun showUsers(users: List<User>) {
        stopLoading()
        adapter.notifyDataSetChanged(users)
    }

}



