package com.example.androidproject.Data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidproject.entities.Event

@Dao
interface EventDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addEvent(event: Event)

    @Query("SELECT * FROM Events")
    fun getAllEvents(): LiveData<List<Event>>


}