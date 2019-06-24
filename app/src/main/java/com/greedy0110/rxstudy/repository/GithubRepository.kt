package com.greedy0110.rxstudy.repository

import android.util.Log
import com.greedy0110.rxstudy.data.Repo
import com.greedy0110.rxstudy.repository.local.LocalSource
import com.greedy0110.rxstudy.repository.remote.RemoteSource
import com.greedy0110.rxstudy.repository.scheduler.GithubScheduler
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class GithubRepository (
    private val remote: RemoteSource,
    private val local: LocalSource,
    private val scheduler: GithubScheduler
) {
    fun getRepo(name: String): Observable<List<Repo>> {
        Log.e("seungmin", "repository getrepo")
        return remote.getRepo(name)
            .subscribeOn(scheduler.io())
            .timeout(3, TimeUnit.SECONDS) // 서버에서 정보를 3초이상 못받아오면 local 데이터를 보여줘볼까? 3초후 onError 발생!
            .doOnError { Log.e("seungmin", "$it 발생") }
            .onErrorResumeNext(local.getRepo(name))
            .observeOn(scheduler.ui())
    }
}