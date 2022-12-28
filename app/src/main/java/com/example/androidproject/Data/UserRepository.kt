package com.example.androidproject.Data


import User
import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val allUsers: LiveData<List<User>> = userDao.getAllUsers()

    suspend fun addUser(user:User){
        userDao.addUser(user)
    }

}