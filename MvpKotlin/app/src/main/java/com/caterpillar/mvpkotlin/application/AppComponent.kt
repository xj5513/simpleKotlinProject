package com.caterpillar.mvpkotlin.application

import com.caterpillar.mvpkotlin.data.DataManager
import com.caterpillar.mvpkotlin.data.source.DataSourceModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by caterpillar on 2017/7/31.
 */

/**
 * dagger2的
 * 注入器
 * 有两种  一种是在需要注入的类加上 @Inject constructor
 * 另一种是在 注入器上配置
 * 本次使用的是第二种方法
 */

//@singleton单例全局存在的  dagger2的注解
//单例的实现不是通过注解实现的  而是自己构建的
@Singleton
@Component(modules = arrayOf(DataSourceModule::class))
interface AppComponent{
    fun dataManager() : DataManager
}