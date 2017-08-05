package com.caterpillar.mvpkotlin.data.source

import com.caterpillar.mvpkotlin.data.Repo
import com.caterpillar.mvpkotlin.data.Users
import io.reactivex.Flowable

/**
 * Created by caterpillar on 2017/7/31.
 */

interface IDataSource {
    fun getUsers(key: String) : Flowable<Users>

    fun getRepo(key: String) : Flowable<List<Repo>>
}
