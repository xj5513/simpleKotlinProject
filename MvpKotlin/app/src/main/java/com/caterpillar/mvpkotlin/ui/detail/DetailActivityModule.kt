package com.caterpillar.mvpkotlin.ui.detail

import com.caterpillar.mvpkotlin.adapter.DetailAdapter
import com.caterpillar.mvpkotlin.data.DataManager
import com.caterpillar.mvpkotlin.persenter.DetailPresenter
import com.caterpillar.mvpkotlin.ui.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by caterpillar on 2017/8/5.
 */

@Module
class DetailActivityModule(val view: DetailActivity){

    @ActivityScope
    @Provides
    fun providePresenter(dataManager: DataManager): DetailPresenter{
        return DetailPresenter(dataManager,view)
    }

    @ActivityScope
    @Provides
    fun provideAdapter(): DetailAdapter {
        return DetailAdapter(view)
    }
}