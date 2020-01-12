package com.example.partpartparttime.ui.history_applicant

import android.app.Application
import androidx.lifecycle.*
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.database.HistoryCompanyDao

class HistoryApplicantViewCompanySelectViewModel(val database: HistoryCompanyDao,
                                                 application: Application, userID: String = MainActivity.loggedUser
): AndroidViewModel(application) {

    private val _navigateToApplicant = MutableLiveData<String>()
    val navigateToCompany get() = _navigateToApplicant

    val historyyy = database.getAllHistorys(userID)

    fun onApplicantClicked(id: String?) {
        _navigateToApplicant.value = id
    }

    fun onApplicantNavigated() {
        _navigateToApplicant.value = null
    }
}