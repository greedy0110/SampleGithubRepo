package com.greedy0110.rxstudy

import android.app.Application
import com.greedy0110.rxstudy.repository.GithubRepository
import com.greedy0110.rxstudy.repository.local.LocalSource
import com.greedy0110.rxstudy.repository.local.MockLocalSource
import com.greedy0110.rxstudy.repository.remote.RemoteSource
import com.greedy0110.rxstudy.repository.remote.RetrofitRemoteSource
import com.greedy0110.rxstudy.repository.repositoryModule
import com.greedy0110.rxstudy.repository.scheduler.AndroidGithubScheduler
import com.greedy0110.rxstudy.repository.scheduler.GithubScheduler
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class SampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SampleApplication)
            modules(
                repositoryModule // repository package 에서 생성해주는 클래스들을 등록
            )
        }
    }
}