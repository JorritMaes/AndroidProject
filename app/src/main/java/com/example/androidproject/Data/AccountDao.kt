package com.example.androidproject.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidproject.entities.Account

@Dao
interface AccountDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAccount(account: Account)

    @Query("SELECT * FROM Accounts WHERE Accounts.userId == :userId")
    fun getUsersAccount(userId: Int)

    @Delete
    fun deleteAccount(account: Account)


}