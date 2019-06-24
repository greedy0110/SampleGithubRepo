package com.greedy0110.rxstudy.repository

import com.greedy0110.rxstudy.repository.local.LocalSource
import com.greedy0110.rxstudy.repository.local.MockLocalSource
import com.greedy0110.rxstudy.repository.remote.RemoteSource
import com.greedy0110.rxstudy.repository.remote.RetrofitRemoteSource
import com.greedy0110.rxstudy.repository.scheduler.AndroidGithubScheduler
import com.greedy0110.rxstudy.repository.scheduler.GithubScheduler
import org.koin.dsl.module

val repositoryModule = module {
    // 아래서 만들어진 놈들을 단순히 get get get! koin 짱 ㅎㅎ
    single { GithubRepository(get(), get(), get()) }

    // repository 만들때 필요한 인자들
    single { MockLocalSource() as LocalSource }
    single { RetrofitRemoteSource() as RemoteSource }
    single { AndroidGithubScheduler() as GithubScheduler }
}