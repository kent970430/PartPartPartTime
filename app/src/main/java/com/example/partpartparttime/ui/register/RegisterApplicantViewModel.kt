package com.example.partpartparttime.ui.register

import android.app.Application
import androidx.lifecycle.*
import com.example.partpartparttime.database.Applicant
import com.example.partpartparttime.database.ApplicantDao
import com.example.partpartparttime.formatApplicants
import kotlinx.coroutines.*

class RegisterApplicantViewModel(val database: ApplicantDao,
                                 application: Application): AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var newapplicant = MutableLiveData<Applicant?>()

    private val _navigateToMain = MutableLiveData<Boolean>()

    val navigateToMain: LiveData<Boolean>
        get() = _navigateToMain

    private val applicants = database.getAllApplicants()

    val formatApplicants = Transformations.map(applicants) { applicants ->
        formatApplicants(applicants, application.resources)
    }

    fun insert(applicant: Applicant){
        uiScope.launch {
            withContext(Dispatchers.IO) {
                database.insert(applicant)

            }
        }
    }

//    fun getStud(): Applicant{
//        var appl: Applicant = Applicant()
//        uiScope.launch {
//            var appl: Applicant? = get()
//        }
//
//        return appl
//    }

//    suspend fun get(): Applicant{
//        return withContext(Dispatchers.IO) {
//            var stud = database.getLastStudent()
//
//            stud
//        }
//    }



//    override fun onCleared() {
//        super.onCleared()
//        viewModelJob.cancel()
//    }
}