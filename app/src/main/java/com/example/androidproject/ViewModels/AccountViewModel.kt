package com.example.androidproject.ViewModels

import User
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidproject.Data.AccountRepository
import com.example.androidproject.Data.UserDatabase
import com.example.androidproject.entities.Account
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccountViewModel(application: Application): AndroidViewModel(application){

    private val repository: AccountRepository

    init {
        val accountDao = UserDatabase.getDatbase(application).accountDao()
        repository = AccountRepository(accountDao)
    }

    fun addAccount(account: Account){
        viewModelScope.launch(Dispatchers.IO){
            repository.addaccount(account)
        }
    }

    fun getAccounts(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.getAccounts(user.userId)
        }
    }

    fun deleteaccount(account: Account){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAccount(account)
        }
    }
}