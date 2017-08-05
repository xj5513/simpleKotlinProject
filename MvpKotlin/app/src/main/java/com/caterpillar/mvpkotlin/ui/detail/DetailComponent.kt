package com.caterpillar.mvpkotlin.ui.detail

import com.caterpillar.mvpkotlin.application.AppComponent
import com.caterpillar.mvpkotlin.ui.ActivityScope
import dagger.Component

/**
 * Created by caterpillar on 2017/8/5.
 */

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class) , modules = arrayOf(DetailActivityModule::class))
interface DetailComponent {

    fun inject(activity: DetailActivity)
}
