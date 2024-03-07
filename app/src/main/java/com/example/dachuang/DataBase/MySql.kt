package com.example.dachuang.DataBase

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dachuang.R
import com.example.dachuang.databinding.ActivityMySqliteBinding

class MySQLite : AppCompatActivity() {
    private lateinit var binding: ActivityMySqliteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMySqliteBinding.inflate(layoutInflater) //绑定布局文件 activity_main.xml 中的视图。
        setContentView(binding.root)

        val dbHelper=MyDatabaseHelper(this,"BookStore.db",1)
        /**
         * 创建表
         */
        binding.btnCreateDataBase.setOnClickListener {
            dbHelper.writableDatabase
        }
        /**
         * 添加数据
         */
        binding.btnAddData.setOnClickListener {
            val db=dbHelper.writableDatabase
            val Values1= ContentValues().apply {
//                第一条数据
                put("name","The Da Vinci Code")
                put("author","Dan Broen")
                put("pages",454)
                put("price",16.96)
            }
            db.insert("Book",null,Values1)
            val  values2=ContentValues().apply {
//                第二条数据
                put("name","The Lost Symbol")
                put("author","Dan Brown")
                put("pages",510)
                put("price",19.95)
            }
            db.insert("Book",null,values2)
        }
        binding.btnUpdateData.setOnClickListener {
            val db=dbHelper.writableDatabase
            val values=ContentValues()
            values.put("price",10.99)
            db.update("Book",values,"name=?", arrayOf("The Da Vinci Code"))
        }
        binding.btnDeleteData.setOnClickListener {
            val db=dbHelper.writableDatabase
            db.delete("Book","pages>?", arrayOf("500"))
        }
        binding.btnQueryData.setOnClickListener {
            val db=dbHelper.writableDatabase
//            查询Book表中所有数据
//            这里获取到是Cursor对象
            val cursor=db.query("Book",null,null,null,null,null,null)
            if (cursor.moveToFirst()){
                do {
                    val name=cursor.getString(cursor.getColumnIndex("name"))
                    val author=cursor.getString(cursor.getColumnIndex("author"))
                    val pages=cursor.getString(cursor.getColumnIndex("pages"))
                    val price=cursor.getString(cursor.getColumnIndex("price"))
                    Log.d("MainActivity","book name is $name")
                    Log.d("MainActivity","author is $author")
                    Log.d("MainActivity","pages is $pages")
                    Log.d("MainActivity","price is $price")
                }while (cursor.moveToNext())
            }
            cursor.close()
        }
    }
}
