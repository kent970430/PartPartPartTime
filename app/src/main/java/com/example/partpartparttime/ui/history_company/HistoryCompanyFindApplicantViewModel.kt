package com.example.partpartparttime.ui.history_company

import android.app.Application
import androidx.lifecycle.*
import com.example.partpartparttime.database.HistoryCompanyDao

class HistoryCompanyFindApplicantViewModel(val database: HistoryCompanyDao,
                                           application: Application
): AndroidViewModel(application) {

    private val _navigateToApplicant = MutableLiveData<String>()
    val navigateToCompany get() = _navigateToApplicant

    val historyyy = database.getAllHistory()

    fun onApplicantClicked(id: String?) {
        _navigateToApplicant.value = id
    }

    fun onApplicantNavigated() {
        _navigateToApplicant.value = null
    }
}