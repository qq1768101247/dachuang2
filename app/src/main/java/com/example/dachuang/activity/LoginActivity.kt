package com.example.dachuang.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dachuang.MainActivity
import com.example.dachuang.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate( savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 设置布局
        val loginButton = binding.loginButton
        val regView = binding.regView
        // 设置按钮点击事件
        loginButton.setOnClickListener {
            //TODO
            // 处理登录逻辑
            // 例如，调用一个方法来检查用户名和密码是否正确，然后导航到主活动或其他页面
            val usernameTextView = binding.usernameEditText.text
            val passwordTextView = binding.passwordEditText.text
            Toast.makeText(this, "账号：${usernameTextView}\n密码：${passwordTextView}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        regView.setOnClickListener {
            //TODO
            // 注册
            val intent = Intent(this, RegActivity::class.java)
            startActivity(intent)
        }
    }
}