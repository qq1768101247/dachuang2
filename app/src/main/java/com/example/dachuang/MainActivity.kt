package com.example.dachuang

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.dachuang.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private var drawerLayout: DrawerLayout? = null
    private var toggle: ActionBarDrawerToggle? = null
    private var navigationView: NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        appBarConfiguration = AppBarConfiguration( //设置toolbar
//            setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
//        setContentView(R.layout.app_bar_main)
//        setSupportActionBar(AppBarMainBinding.inflate(layoutInflater).toolbar)

        drawerLayout = binding.drawerLayout
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout!!.addDrawerListener(toggle!!)
        toggle!!.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        drawerLayout!!.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                // 可以在这里添加逻辑来处理抽屉滑动事件
            }

            override fun onDrawerOpened(drawerView: View) {
                // 当抽屉打开时隐藏 Toolbar
                supportActionBar?.hide()
            }

            override fun onDrawerClosed(drawerView: View) {
                // 当抽屉关闭时显示 Toolbar
                supportActionBar?.show()
            }

            override fun onDrawerStateChanged(newState: Int) {
                // 可以在这里添加逻辑来处理抽屉状态变化事件
            }
        })


        navigationView = binding.navLeftView
// 为 NavigationView 设置点击监听器
        navigationView!!.setNavigationItemSelectedListener { menuItem ->
            // 处理菜单项的点击事件

            false
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (toggle!!.onOptionsItemSelected(item)) {
            true
        } else {
            // 如果是其他菜单项，调用 super 方法处理
            super.onOptionsItemSelected(item)
        }
    }


}

