package com.example.androidproject.Data

import User
import com.example.androidproject.entities.Account

class AccountRepository(private val accountDao: AccountDao) {

    suspend fun addaccount(account: Account){
        accountDao.addAccount(account)
    }

    suspend fun getAccounts(userId: Int){
        accountDao.getUsersAccount(userId)
    }

    suspend fun deleteAccount(account: Account){
        accountDao.deleteAccount(account)
    }
}