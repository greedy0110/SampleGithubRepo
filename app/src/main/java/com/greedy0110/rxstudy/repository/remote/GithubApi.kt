package com.greedy0110.rxstudy.repository.remote

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    /*
    * https://developer.github.com/v3/repos/#list-user-repositories
    * Github Restful API 참조
    * */
    @GET("users/{user}/repos")
    fun getRepo(
        @Path("user") username: String
    ): Observable<List<RepoResponse>>
}