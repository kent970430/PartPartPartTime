package com.example.partpartparttime.ui.history_applicant

import android.app.Application
import androidx.lifecycle.*
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.database.HistoryApplicantDao

class HistoryApplicantFindCompanyViewModel (val database: HistoryApplicantDao,
                                            application: Application, user_id : String = MainActivity.loggedUser
): AndroidViewModel(application) {

    private val _navigateToCompany = MutableLiveData<String>()
    val navigateToCompany get() = _navigateToCompany

    val historyyy = database.getAllHistory(user_id)

    fun onCompanyClicked(id: String?) {
        _navigateToCompany.value = id
    }

    fun onCompanyNavigated() {
        _navigateToCompany.value = null
    }
}