package com.caterpillar.mvpkotlin.application

import android.app.Application
import com.caterpillar.mvpkotlin.data.source.DataSourceModule

/**
 * Created by caterpillar on 2017/7/31.
 */

class MyApplication : Application(){

    lateinit private var appComponent : AppComponent

    companion object{
        lateinit private var app : MyApplication

        fun getApplication(): MyApplication = app
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        appComponent = DaggerAppComponent.builder().dataSourceModule(DataSourceModule()).build()
    }

    fun getAppComponent(): AppComponent = appComponent
}