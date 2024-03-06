package com.example.dachuang.sql

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper


class MySQLiteHelper(
    context: Context?, name: String?, factory: CursorFactory?,
    version: Int,
) : SQLiteOpenHelper(context, name, factory, version) {
    private val CREATE_NEWS : String = "create table news (" +
            "id integer primary key autoincrement, " +
            "title text, " +
            "content text, " +
            "publishdate integer," +
            "commentcount integer)"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_NEWS)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}
}