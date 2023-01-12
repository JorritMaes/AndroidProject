package com.example.androidproject.entities

import User
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="Accounts")
data class Account(var Service: Service,
                   @PrimaryKey
                   var name: String, var userId: Int){


}
