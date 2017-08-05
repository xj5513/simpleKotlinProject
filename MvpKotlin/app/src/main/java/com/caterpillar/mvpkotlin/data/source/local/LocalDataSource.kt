package com.caterpillar.mvpkotlin.data.source.local

import com.caterpillar.mvpkotlin.data.Repo
import com.caterpillar.mvpkotlin.data.Users
import com.caterpillar.mvpkotlin.data.source.IDataSource
import io.reactivex.Flowable

/**
 * Created by caterpillar on 2017/7/31.
 */

class LocalDataSource : IDataSource{
    override fun getRepo(key: String): Flowable<List<Repo>> {
        return Flowable.just(arrayListOf())
    }

    override fun getUsers(keu: String): Flowable<Users> {
        return Flowable.just(Users(arrayListOf()))
    }

}
