package com.example.androidproject.Data


import User

class UserRepository(private val userDao: UserDao) {

    val allUsers = userDao.getAllUsers()

    suspend fun  getUser(userId: Int){
        userDao.getUser(userId)
    }

    suspend fun addUser(user:User){
        userDao.addUser(user)
    }

}