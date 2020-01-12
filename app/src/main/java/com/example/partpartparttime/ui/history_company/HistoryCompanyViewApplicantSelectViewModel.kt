package com.example.partpartparttime.ui.history_company

import android.app.Application
import androidx.lifecycle.*
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.database.HistoryApplicantDao

class HistoryCompanyViewApplicantSelectViewModel (val database: HistoryApplicantDao,
                                                  application: Application, userID: String = MainActivity.loggedUser
): AndroidViewModel(application) {

    private val _navigateToCompany = MutableLiveData<String>()
    val navigateToCompany get() = _navigateToCompany

    val historyyy = database.getAllHistorys(userID)

    fun onCompanyClicked(id: String?) {
        _navigateToCompany.value = id
    }

    fun onCompanyNavigated() {
        _navigateToCompany.value = null
    }
}