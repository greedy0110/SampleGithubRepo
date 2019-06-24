package com.greedy0110.rxstudy.repository.scheduler

import io.reactivex.Scheduler

interface GithubScheduler {
    fun io(): Scheduler
    fun ui(): Scheduler
}