package com.example.dachuang.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dachuang.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sp: SharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE)
        val user = sp.getString("user", "") ?: "" // 如果没有找到，返回空字符串

        val clazz: Class<*> = if (user.isEmpty()) {
            LoginActivity::class.java
        } else {
            MainActivity::class.java
        }

        finishAffinity() // 结束当前活动并清理所有关联的堆栈
        val intent = Intent(this, clazz)
        startActivity(intent)
    }
}
