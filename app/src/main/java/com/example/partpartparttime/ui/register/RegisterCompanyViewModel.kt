package com.example.partpartparttime.ui.register

import android.app.Application
import androidx.lifecycle.*
import com.example.partpartparttime.database.Company
import com.example.partpartparttime.database.CompanyDao
import com.example.partpartparttime.formatCompanys
import kotlinx.coroutines.*

class RegisterCompanyViewModel(val database: CompanyDao,
                               application: Application): AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var newcompany= MutableLiveData<Company?>()

    private val _navigateToMain = MutableLiveData<Boolean>()

    val navigateToMain: LiveData<Boolean>
        get() = _navigateToMain

    private val companys = database.getAllCompanys()

    val formatCompanys = Transformations.map(companys) { companys ->
        formatCompanys(companys, application.resources)
    }

    fun insert(company: Company){
        uiScope.launch {
            withContext(Dispatchers.IO) {
                database.insert(company)

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