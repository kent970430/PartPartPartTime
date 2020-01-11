package com.example.partpartparttime.ui.history_company

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.partpartparttime.database.HistoryCompanyDao

class HistoryCompanyFindApplicantViewModelFactory(val dataSource: HistoryCompanyDao,
                                                  private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HistoryCompanyFindApplicantViewModel::class.java)) {
            return HistoryCompanyFindApplicantViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}