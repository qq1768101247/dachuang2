package com.example.dachuang.DataBase

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.Ignore
import io.realm.kotlin.types.annotations.PrimaryKey


class User : RealmObject {
    @PrimaryKey
    private var id = 0
    private var name: String? = null
    private var age = 0

    @Ignore
    private val sessionId = 0
    fun IsEmptyName(): Boolean {
        return name!!.isEmpty()
    }
}