package com.greedy0110.rxstudy.ui.main

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.greedy0110.rxstudy.R
import com.greedy0110.rxstudy.repository.GithubRepository
import com.greedy0110.rxstudy.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity() {
    private val repository: GithubRepository by inject() // application 에서 startKoin 으로 등록한 repository 를 받아!

    private val adapter: RepoAdapter by lazy { RepoAdapter(this, listOf()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ui 관련 코드
        rv_main_repo.adapter = adapter
        rv_main_repo.layoutManager = LinearLayoutManager(this)

        // 데이터를 받아오는(서버든, 로컬이든은 repository 내부에서 결정한다!) 비동기 코드
        repository.getRepo("greedy0110")
            // 어디서든 데이터를 받아오면! 받아온 데이터를 가지고...
            .subscribe { data ->
                // ui 를 갱신해준다.
                adapter.data = data
                adapter.notifyDataSetChanged()
            }.apply { addDisposable(this) }
    }
}
