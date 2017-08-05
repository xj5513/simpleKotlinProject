package com.caterpillar.mvpkotlin.ui.main

import com.caterpillar.mvpkotlin.data.User
import com.caterpillar.mvpkotlin.ui.IViews

/**
 * Created by caterpillar on 2017/7/31.
 */

interface MainView : IViews {

    fun  showUsers(users: List<User>)

}
