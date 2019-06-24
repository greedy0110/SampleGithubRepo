package com.greedy0110.rxstudy.repository.remote

data class RepoResponse(
    val name: String,
    val description: String,
    var url: String
    // 기타 많은 데이터들 이 추가되고 변경될 수 있다.
)