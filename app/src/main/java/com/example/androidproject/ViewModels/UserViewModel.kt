package com.example.androidproject.ViewModels

import User
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidproject.Data.UserDatabase
import com.example.androidproject.Data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application){
    public val allUsers: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatbase(application).userDao()
        repository = UserRepository(userDao)
        allUsers = repository.allUsers
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }

}