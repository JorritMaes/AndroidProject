package com.example.androidproject.entities

data class User(var username: String) {
    var accounts: ArrayList<Account> = ArrayList()
    var friends: ArrayList<User> = ArrayList()
    var acceptedEvents: ArrayList<Event> = ArrayList()
    var pendingEvents: ArrayList<Event> = ArrayList()
}