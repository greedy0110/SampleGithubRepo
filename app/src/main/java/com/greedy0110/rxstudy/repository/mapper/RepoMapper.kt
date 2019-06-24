package com.greedy0110.rxstudy.repository.mapper

import com.greedy0110.rxstudy.data.Repo
import com.greedy0110.rxstudy.repository.remote.RepoResponse

object RepoMapper: BaseMapper<RepoResponse, Repo> {
    override fun toUIData(dbData: RepoResponse): Repo {
        return Repo( // dbData 에서 필요한 데이터만 추출
            repo_name = dbData.name
        )
    }

    override fun toDBData(uiData: Repo): RepoResponse {
        return RepoResponse( // TODO GET 함수에서는 쓸모가 없다?!
            url = "",
            name = uiData.repo_name,
            description = ""
        )
    }
}