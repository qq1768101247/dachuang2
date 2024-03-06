package com.example.dachuang.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.dachuang.databinding.ActivityRegBinding

class RegActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 设置注册按钮点击监听器
        binding.signupbtn.setOnClickListener {
            val username = binding.username.text.toString()
            val phone = binding.phone.text.toString()
            val password = binding.password.text.toString()
            val repassword = binding.repassword.text.toString()

            if (username.isEmpty() || phone.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
                Toast.makeText(this, "所有字段都是必填的", Toast.LENGTH_SHORT).show()
            } else if (password != repassword) {
                Toast.makeText(this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show()
            } else {
                //TODO
                // 在这里添加注册逻辑
                Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
