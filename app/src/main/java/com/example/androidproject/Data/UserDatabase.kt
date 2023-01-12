package com.example.androidproject.Data


import User
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidproject.entities.Account
import com.example.androidproject.entities.Event

@Database(entities = [User::class,Account::class, Event::class], version=1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun accountDao():AccountDao
    abstract fun eventDao():EventDao

    companion object {

        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatbase(context: Context) : UserDatabase{
            val tempInstance = INSTANCE
            if(tempInstance !=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance            }
        }
    }
}