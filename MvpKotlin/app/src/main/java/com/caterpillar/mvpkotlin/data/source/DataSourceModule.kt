package com.caterpillar.mvpkotlin.data.source

import com.caterpillar.mvpkotlin.data.BASE_URL
import com.caterpillar.mvpkotlin.data.DataManager
import com.caterpillar.mvpkotlin.data.source.local.Local
import com.caterpillar.mvpkotlin.data.source.local.LocalDataSource
import com.caterpillar.mvpkotlin.data.source.remote.Remote
import com.caterpillar.mvpkotlin.data.source.remote.RemoteDataSource
import com.caterpillar.mvpkotlin.retrofit.GitHubService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by caterpillar on 2017/7/31.
 */

@Module
class DataSourceModule{
    @Singleton
    @Provides
    fun provideGitHubService(): GitHubService{
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL).build().create(GitHubService::class.java)
    }

    @Singleton
    @Remote
    @Provides
    fun provideRemote(service: GitHubService): IDataSource{
        return RemoteDataSource(service)
    }

    @Singleton
    @Local
    @Provides
    fun provideLocal(): IDataSource{
            return LocalDataSource()
    }


    /**
     * 此两种方法都可行
     */

    //    @Named("11")
//    @Provides
//    fun provideLocal(): IDataSource{
//
//    }
//    @Provides
//    fun provideDataManager(@Named("11") remote: IDataSource,@Local local: IDataSource): DataManager{
//        return DataManager(remote,local)
//    }

    @Singleton
    @Provides
    fun provideDataManager(@Remote remote: IDataSource,@Local local: IDataSource): DataManager{
        return DataManager(remote,local)
    }
}