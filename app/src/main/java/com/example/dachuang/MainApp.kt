package com.example.dachuang
import android.app.Application
import com.example.dachuang.DataBase.User
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
//import org.ktorm.database.Database
import java.sql.DriverManager

open class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()


    }
}
