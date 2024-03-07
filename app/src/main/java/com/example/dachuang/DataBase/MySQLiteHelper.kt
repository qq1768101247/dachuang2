package com.example.dachuang.DataBase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class MyDatabaseHelper(var context: Context, name: String, version: Int) :
    SQLiteOpenHelper(context, name, null, version) {
    var createBook="create table Book (" +
            "id integer primary key autoincrement," +
            "author text," +
            "price real," +
            "pages integer," +
            "name text)"

    override fun onCreate(db: SQLiteDatabase?) {
//        下面这个todo 如果不注释掉的话就会报错。
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        db?.execSQL(createBook)
        Toast.makeText(context,"Create Successed",Toast.LENGTH_LONG).show()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        db?.execSQL("drop table if exists Book")
        onCreate(db)
    }
}
