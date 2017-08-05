package com.caterpillar.mvpkotlin.data

import com.caterpillar.mvpkotlin.data.source.IDataSource
import io.reactivex.Flowable

/**
 * Created by caterpillar on 2017/7/31.
 */

class DataManager(val remote: IDataSource, val local: IDataSource){

    fun getUsers(key: String) : Flowable<List<User>>{
        return remote.getUsers(key).onErrorResumeNext(local.getUsers(key)).map {
            it.items
        }
    }
    fun getRepo(path:String): Flowable<List<Repo>> {
        return remote.getRepo(path).onErrorResumeNext(local.getRepo(path))
    }
}
