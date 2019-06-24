package com.greedy0110.rxstudy.repository.mapper

interface BaseMapper<DBData, UIData> {
    fun toUIData(dbData: DBData): UIData
    fun toDBData(uiData: UIData): DBData
}