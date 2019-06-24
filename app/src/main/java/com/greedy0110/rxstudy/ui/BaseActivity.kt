package com.greedy0110.rxstudy.ui

import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseActivity : AppCompatActivity() {
    private val compositeDisposable = CompositeDisposable()

    protected fun addDisposable(disposable: Disposable){
        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}