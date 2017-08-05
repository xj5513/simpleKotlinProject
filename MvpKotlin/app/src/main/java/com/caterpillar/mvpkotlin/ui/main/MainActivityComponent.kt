package com.caterpillar.mvpkotlin.ui.main

import com.caterpillar.mvpkotlin.application.AppComponent
import com.caterpillar.mvpkotlin.ui.ActivityScope
import dagger.Component

/**
 * Created by caterpillar on 2017/7/31.
 */


@ActivityScope
@Component(modules = arrayOf(MainActivityModule::class),dependencies = arrayOf(AppComponent::class))
interface MainActivityComponent{
    fun inject(activity: MainActivity)
}