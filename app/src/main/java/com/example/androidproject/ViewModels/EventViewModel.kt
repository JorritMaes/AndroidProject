package com.example.androidproject.ViewModels

import User
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidproject.Data.AccountRepository
import com.example.androidproject.Data.UserDatabase
import com.example.androidproject.Data.model.Eventrepository
import com.example.androidproject.entities.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventViewModel(application: Application): AndroidViewModel(application) {

    private val repository: Eventrepository

    init {
        val eventDao = UserDatabase.getDatbase(application).eventDao()
        repository = Eventrepository(eventDao)
        var allEvents = repository.allEvents
    }

    fun addEvent(event: Event){
        viewModelScope.launch(Dispatchers.IO){
            repository.addEvent(event)
        }
    }

}