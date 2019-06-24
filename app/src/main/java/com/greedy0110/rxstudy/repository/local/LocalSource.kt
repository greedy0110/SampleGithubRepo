package com.greedy0110.rxstudy.repository.local

import com.greedy0110.rxstudy.data.Repo
import io.reactivex.Observable
import io.reactivex.Single

interface LocalSource {
    fun getRepo(name: String): Observable<List<Repo>>
}
