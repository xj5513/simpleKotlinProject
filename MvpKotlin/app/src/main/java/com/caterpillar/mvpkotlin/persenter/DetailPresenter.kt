package com.caterpillar.mvpkotlin.persenter

import com.caterpillar.mvpkotlin.data.DataManager
import com.caterpillar.mvpkotlin.ui.detail.DetailView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by caterpillar on 2017/8/5.
 */

class DetailPresenter(val dataManager: DataManager, val views: DetailView){

    fun getRepo(key: String){
        dataManager.getRepo(key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { views.startLoading() }
                .doOnError { views.stopLoading()  }
                .subscribe{ views.showRepo(it)}
    }
}
