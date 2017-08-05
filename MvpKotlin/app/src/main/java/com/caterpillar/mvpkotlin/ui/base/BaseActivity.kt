package com.caterpillar.mvpkotlin.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.caterpillar.mvpkotlin.application.AppComponent
import com.caterpillar.mvpkotlin.application.MyApplication
import org.jetbrains.anko.indeterminateProgressDialog

abstract class BaseActivity : AppCompatActivity() {

    var progressDialog : ProgressDialog?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(attachLayoutId())
        setUpComponent(MyApplication.getApplication().getAppComponent())
        initViews()
    }

    abstract fun initViews()

    abstract fun attachLayoutId(): Int

    abstract fun setUpComponent(appComponent: AppComponent)

    open fun stopLoading() {
        progressDialog?.dismiss()
    }
    open fun startLoading() {
        if(null === progressDialog){
            progressDialog = indeterminateProgressDialog("正在加载。。。")
        }else{
            progressDialog?.show()
        }
    }
}
