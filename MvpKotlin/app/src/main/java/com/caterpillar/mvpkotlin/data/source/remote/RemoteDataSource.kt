package com.caterpillar.mvpkotlin.data.source.remote

import com.caterpillar.mvpkotlin.data.Repo
import com.caterpillar.mvpkotlin.data.Users
import com.caterpillar.mvpkotlin.data.source.IDataSource
import com.caterpillar.mvpkotlin.retrofit.GitHubService
import io.reactivex.Flowable

/**
 * Created by caterpillar on 2017/7/31.
 */

class RemoteDataSource(val service: GitHubService) : IDataSource {
    override fun getRepo(key: String): Flowable<List<Repo>> {
        return service.getRepo(key)
    }

    override fun getUsers(key: String): Flowable<Users> {
        return service.getUsers(key)
    }

}