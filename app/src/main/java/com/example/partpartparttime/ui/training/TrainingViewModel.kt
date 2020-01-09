package com.example.partpartparttime.ui.training

import android.app.Application
import androidx.lifecycle.*
import com.example.partpartparttime.database.TrainingDao

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
}