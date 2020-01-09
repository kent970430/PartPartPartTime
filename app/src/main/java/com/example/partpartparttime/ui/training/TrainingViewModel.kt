package com.example.partpartparttime.ui.training

import android.app.Application
import androidx.lifecycle.*
import com.example.partpartparttime.database.Training
import com.example.partpartparttime.database.TrainingDao
import kotlinx.coroutines.*

class TrainingViewModel(val database: TrainingDao,
                        application: Application) : AndroidViewModel(application)
{
    private val _navigateToTraining = MutableLiveData<String>()
    val navigateToTraining get() = _navigateToTraining

    val trainingggg = database.getAllTraining()

    fun onTrainingClicked(id: String?){
        _navigateToTraining.value = id
    }

    fun onTrainingNavigated(){
        _navigateToTraining.value = null
    }

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun insert(trainn: Training){
        uiScope.launch {
            withContext(Dispatchers.IO) {
                database.insert(trainn)
            }
        }
    }
}