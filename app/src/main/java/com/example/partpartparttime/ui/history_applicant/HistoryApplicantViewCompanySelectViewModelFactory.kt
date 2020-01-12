package com.example.partpartparttime.ui.history_applicant

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.database.HistoryCompanyDao

class HistoryApplicantViewCompanySelectViewModelFactory(
    val dataSource: HistoryCompanyDao,
    private val application: Application, val userID: String = MainActivity.loggedUser
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HistoryApplicantViewCompanySelectViewModel::class.java)) {
            return HistoryApplicantViewCompanySelectViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}