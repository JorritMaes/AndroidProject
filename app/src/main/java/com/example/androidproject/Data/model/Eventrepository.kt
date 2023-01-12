package com.example.androidproject.Data.model

import androidx.lifecycle.LiveData
import com.example.androidproject.Data.EventDao
import com.example.androidproject.entities.Event

class Eventrepository(private val eventDao: EventDao) {

    public val allEvents = eventDao.getAllEvents()

    suspend fun addEvent(event: Event){
        eventDao.addEvent(event)
    }


}