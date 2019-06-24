package com.greedy0110.rxstudy.repository.remote

import android.util.Log
import com.greedy0110.rxstudy.data.Repo
import com.greedy0110.rxstudy.repository.mapper.RepoMapper
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitRemoteSource: RemoteSource {
    // https://developer.github.com/v3/ 참조
    private val baseUrl = "https://api.github.com"
    private val retrofit: GithubApi by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(OkHttpClient()) // TODO 이 부분에 대한 정확한 이해 필요. 없으면 http 처리에 문제가 발생
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // Call 객체를 RxJava 로 변환하겠다.
            .addConverterFactory(GsonConverterFactory.create()) // 받아온 데이터를 json 형태로 변환해서 해석하겠다.
            .build().create(GithubApi::class.java)
    }

    override fun getRepo(name: String): Observable<List<Repo>> {
        return retrofit.getRepo(name)
            .map { it.map { repoResponse ->  RepoMapper.toUIData(repoResponse) } } // retrofit response 를 변환해서 data package 에 데이터로 반환해준다.
    }
}