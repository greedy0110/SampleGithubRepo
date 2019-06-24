package com.greedy0110.rxstudy.repository.local

import com.greedy0110.rxstudy.data.Repo
import io.reactivex.Observable

class MockLocalSource : LocalSource {
    override fun getRepo(name: String): Observable<List<Repo>> {
        return Observable.just(
            listOf(
                Repo(repo_name = "mock 1"),
                Repo(repo_name = "mock 2"),
                Repo(repo_name = "mock 3"),
                Repo(repo_name = "mock 4"),
                Repo(repo_name = "mock 5")
            )
        )
    }
}