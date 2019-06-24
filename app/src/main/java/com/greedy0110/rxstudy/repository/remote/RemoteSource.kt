package com.greedy0110.rxstudy.repository.remote

import com.greedy0110.rxstudy.data.Repo
import io.reactivex.Observable

interface RemoteSource {
    fun getRepo(name: String): Observable<List<Repo>>
}
