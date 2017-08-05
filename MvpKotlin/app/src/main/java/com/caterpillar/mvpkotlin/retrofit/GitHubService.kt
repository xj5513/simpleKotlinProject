package com.caterpillar.mvpkotlin.retrofit

import com.caterpillar.mvpkotlin.data.Repo
import com.caterpillar.mvpkotlin.data.Users
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * Created by caterpillar on 2017/7/31.
 */


//retrofit 接口
interface GitHubService{
    @GET("search/users")
    fun getUsers(@Query("q")key:String):Flowable<Users>

    @GET
    fun getRepo(@Url path:String):Flowable<List<Repo>>
}