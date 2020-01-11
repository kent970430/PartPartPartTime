package com.example.partpartparttime.ui.search_applicant

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.partpartparttime.database.ApplicantDao
import com.example.partpartparttime.database.MatchDao

class SearchApplicantViewModelFactory(private val dataSource: ApplicantDao,
                                      private val application: Application
) : ViewModelProvider.Factory  {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchApplicantViewModel::class.java)) {
            return SearchApplicantViewModel(dataSource,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}