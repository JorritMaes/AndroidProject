package com.example.androidproject.entities

import User
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "Events")
data class Event(@PrimaryKey(autoGenerate = true) var eventId: Int, var startDate: Date, var endDate: Date, var title: String, var host: User){
    var membersId: ArrayList<Int> = ArrayList()


}
