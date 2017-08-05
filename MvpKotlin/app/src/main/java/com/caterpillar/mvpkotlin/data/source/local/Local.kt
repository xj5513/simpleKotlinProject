package com.caterpillar.mvpkotlin.data.source.local

import javax.inject.Qualifier

/**
 * Created by caterpillar on 2017/7/31.
 */


/**
 * 限定符
 * 当出现多个provide方法返回相同类型的时候
 * 需要使用dagger2来注入对象的地方不知道使用哪个provide方法
 *相同限定符申明的对象和方法
 */
@Qualifier
annotation class Local