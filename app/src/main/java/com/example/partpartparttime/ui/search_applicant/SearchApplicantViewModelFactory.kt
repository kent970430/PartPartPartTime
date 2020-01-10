package com.example.partpartparttime.ui.search_applicant

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.partpartparttime.database.MatchDao

class SearchApplicantViewModelFactory(private val dataSource: MatchDao,
                                      private val application: Application, val company_id:String, val user_id:String, val status: String
) : ViewModelProvider.Factory  {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchApplicantViewModel::class.java)) {
            return SearchApplicantViewModel(dataSource,application,company_id,user_id,status) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}