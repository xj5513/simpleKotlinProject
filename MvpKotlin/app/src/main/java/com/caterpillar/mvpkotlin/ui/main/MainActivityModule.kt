package com.caterpillar.mvpkotlin.ui.main

import com.caterpillar.mvpkotlin.adapter.MainAdapter
import com.caterpillar.mvpkotlin.data.DataManager
import com.caterpillar.mvpkotlin.persenter.MainPresenter
import com.caterpillar.mvpkotlin.ui.ActivityScope
import com.caterpillar.mvpkotlin.ui.main.MainActivity
import dagger.Module
import dagger.Provides

/**
 * Created by caterpillar on 2017/7/31.
 */


@Module
class MainActivityModule(val view: MainActivity){

    @ActivityScope
    @Provides
    fun providePresenter(dataManager: DataManager): MainPresenter {
        return MainPresenter(dataManager,view)
    }

    @ActivityScope
    @Provides
    fun provideAdapter(): MainAdapter {
        return MainAdapter(view)
    }
}
