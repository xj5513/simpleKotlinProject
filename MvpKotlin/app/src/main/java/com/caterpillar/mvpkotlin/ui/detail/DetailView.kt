package com.caterpillar.mvpkotlin.ui.detail

import com.caterpillar.mvpkotlin.data.Repo
import com.caterpillar.mvpkotlin.ui.IViews

/**
 * Created by caterpillar on 2017/8/5.
 */

interface DetailView: IViews{
    fun  showRepo(repo: List<Repo>)

}
