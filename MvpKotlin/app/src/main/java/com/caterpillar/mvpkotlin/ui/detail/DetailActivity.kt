package com.caterpillar.mvpkotlin.ui.detail

import android.support.v7.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.caterpillar.mvpkotlin.application.AppComponent
import com.caterpillar.mvpkotlin.ui.base.BaseActivity
import com.caterpillar.mvpkotlin.R
import com.caterpillar.mvpkotlin.adapter.DetailAdapter
import com.caterpillar.mvpkotlin.data.Repo
import com.caterpillar.mvpkotlin.data.User
import com.caterpillar.mvpkotlin.persenter.DetailPresenter
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

/**
 * Created by caterpillar on 2017/8/5.
 */

class DetailActivity : BaseActivity(),DetailView{
    override fun showRepo(repo: List<Repo>) {
        stopLoading()
        adapter.notifyDataSetChanged(repo)
    }

    @Inject
    lateinit var presenter : DetailPresenter
    @Inject
    lateinit var adapter : DetailAdapter


    override fun initViews() {
        val user = intent.getParcelableExtra<User>("user")
        Glide.with(this).load(user.avatar_url).into(detail_avatar)
        detail_name.text = user.name
        detailRecyclerView.layoutManager = LinearLayoutManager(this)
        detailRecyclerView.adapter = adapter
        presenter.getRepo(user.repos_url)
    }

    override fun attachLayoutId(): Int = R.layout.activity_detail

    override fun setUpComponent(appComponent: AppComponent) {
        DaggerDetailComponent.builder()
                .appComponent(appComponent)
                .detailActivityModule(DetailActivityModule(this@DetailActivity))
                .build().inject(this@DetailActivity)
    }

}