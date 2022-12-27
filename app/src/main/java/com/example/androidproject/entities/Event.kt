package com.example.androidproject.entities

import java.util.Date

data class Event(var startDate: Date, var endDate: Date, var title: String, var host:User){
    var members: ArrayList<User> = ArrayList()


}
