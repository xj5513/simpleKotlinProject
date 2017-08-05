package com.caterpillar.mvpkotlin.persenter

import com.caterpillar.mvpkotlin.data.DataManager
import com.caterpillar.mvpkotlin.ui.main.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by caterpillar on 2017/7/31.
 */


//view层引用和  model层的引用
class MainPresenter(val dataManager: DataManager,val views: MainView){

    fun getUsers(key: String){
        dataManager.getUsers(key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { views.startLoading() }
                .doOnError { views.stopLoading()  }
                .subscribe{ views.showUsers(it)}
    }
}
