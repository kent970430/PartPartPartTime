package com.example.partpartparttime.ui.events

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.partpartparttime.database.EventDao

class EventsViewModelFactory(private val eventID: Int,
                                  val dataSource: EventDao,
                                  private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EventsViewModel::class.java)) {
            return EventsViewModel(eventID,dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}