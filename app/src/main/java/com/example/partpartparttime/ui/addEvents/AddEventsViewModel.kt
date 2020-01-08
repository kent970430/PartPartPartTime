package com.example.partpartparttime.ui.addEvents

import android.app.Application
import androidx.lifecycle.*
import com.example.partpartparttime.database.*
import com.example.partpartparttime.formatEvents
import kotlinx.coroutines.*

class AddEventsViewModel(val database: EventDao,
                         application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var newEvent= MutableLiveData<Event?>()

    private val eventss = database.getAllEvents()

    val formatEvents = Transformations.map(eventss) { eeventt ->
        formatEvents(eeventt, application.resources)
    }

    fun insert(eventt: Event){
        uiScope.launch {
            withContext(Dispatchers.IO) {
                database.insert(eventt)
            }
        }
    }
}