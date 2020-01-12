package com.example.partpartparttime.ui.history_company

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.database.HistoryApplicantDao

class HistoryCompanyViewApplicantSelectViewModelFactory (val dataSource: HistoryApplicantDao,
                                                         private val application: Application,private val userID : String= MainActivity.loggedUser
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HistoryCompanyViewApplicantSelectViewModel::class.java)) {
            return HistoryCompanyViewApplicantSelectViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}