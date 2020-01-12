package com.example.partpartparttime.ui.history_company

import android.app.Application
import androidx.lifecycle.*
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.database.HistoryCompanyDao

class HistoryCompanyFindApplicantViewModel(val database: HistoryCompanyDao,
                                           application: Application, company_id : String = MainActivity.loggedUser
): AndroidViewModel(application) {

    private val _navigateToApplicant = MutableLiveData<String>()
    val navigateToCompany get() = _navigateToApplicant

    val historyyy = database.getAllHistory(company_id)

    fun onApplicantClicked(id: String?) {
        _navigateToApplicant.value = id
    }

    fun onApplicantNavigated() {
        _navigateToApplicant.value = null
    }
}