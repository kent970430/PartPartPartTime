package com.example.partpartparttime.ui.search_applicant

import android.app.Application
import android.media.MediaRouter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.database.ApplicantDao

class SearchApplicantViewModelFactory(private val dataSource: ApplicantDao,
                                      private val application: Application , private val categoryy : String= MainActivity.categoryyyyy
) : ViewModelProvider.Factory  {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchApplicantViewModel::class.java)) {
            return SearchApplicantViewModel(dataSource,application,categoryy) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}