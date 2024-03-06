package com.example.dachuang.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dachuang.MainActivity
import com.example.dachuang.databinding.ActivityLoginBinding

import android.content.SharedPreferences

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate( savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 设置布局
        val loginButton = binding.loginButton
        val regView = binding.regBt
        // 设置按钮点击事件
        loginButton.setOnClickListener {
            //TODO
            // 处理登录逻辑
            // 例如，调用一个方法来检查用户名和密码是否正确，然后导航到主活动或其他页面
            val usernameTextView = binding.usernameEditText.text
            val passwordTextView = binding.passwordEditText.text
            if (usernameTextView.toString().isEmpty()){
                //TODO
                // 登陆失败
                Toast.makeText(this, "账号或密码错误", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else{
                //TODO
                // 登陆成功

                val sp:SharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE)
                val editor = sp.edit()
                editor.putString("user", usernameTextView.toString())
                editor.putString("type", "1")
//                editor.putString("name", list.get(0).getName()) ;
//                editor.putString("pwd", pwd) ;
//                editor.putString("type", list.get(0).getType()) ;
//                editor.putString("id", list.get(0).getId()+"") ;
                editor.apply()

                finishAffinity()
                Toast.makeText(this, "账号：${usernameTextView}\n密码：${passwordTextView}", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        regView.setOnClickListener {
            val intent = Intent(this, RegActivity::class.java)
            startActivity(intent)
        }
    }
}