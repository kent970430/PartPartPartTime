package com.example.partpartparttime.ui.events

import android.app.Application
import androidx.lifecycle.*
import com.example.partpartparttime.database.Event
import com.example.partpartparttime.database.EventDao

class EventsViewModel(val database: EventDao,
                      application: Application
): AndroidViewModel(application){

    private val _navigateToCompany = MutableLiveData<Int>()
    val navigateToCompany get() =_navigateToCompany

    val eventttt = database.getAllEvents()

    fun onEventClicked(id: Int) {
        _navigateToCompany.value = id
    }

    fun onEventNavigated() {
        _navigateToCompany.value = null
    }

//    private var _showSnackbarEvent = MutableLiveData<Boolean?>()
//    val showSnackBarEvent: LiveData<Boolean?>
//        get() = _showSnackbarEvent
//
//
//    fun doneShowingSnackbar() {
//        _showSnackbarEvent.value = null
//    }
//    val eventsString = Transformations.map(eventttt) { eventttt ->
//        formatEvents(eventttt, application.resources)
//    }
//
//    val clearButtonVisible = Transformations.map(eventttt) {
//        it?.isNotEmpty()
//    }
}
