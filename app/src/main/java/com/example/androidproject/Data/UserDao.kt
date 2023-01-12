package com.example.androidproject.Data

import User
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
//https://developer.android.com/training/data-storage/room/accessing-data
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user :User)

    @Query("SELECT * FROM Users")
    fun getAllUsers():LiveData<List<User>>

    @Query("SELECT * FROM Users WHERE userId == :userId")
    fun getUser(userId: Int)


    @Delete
    fun deleteUser(user: User)


}