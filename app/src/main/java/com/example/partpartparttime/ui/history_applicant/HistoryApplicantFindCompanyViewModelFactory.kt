package com.example.partpartparttime.ui.history_applicant

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.partpartparttime.database.HistoryApplicantDao

class HistoryApplicantFindCompanyViewModelFactory(val dataSource: HistoryApplicantDao,
                                                  private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HistoryApplicantFindCompanyViewModel::class.java)) {
            return HistoryApplicantFindCompanyViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
